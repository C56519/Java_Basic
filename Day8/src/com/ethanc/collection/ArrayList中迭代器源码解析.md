# ArrayList中迭代器源码解析
## 使用

怎么使用迭代器？

1. 先创造一个迭代器对象。

```java
// 创建测试ArrayList
ArrayList<Integer> arrlist = new ArrayList<Integer>();
arrlist.add(13);
arrlist.add(22);
arrlist.add(38);
arrlist.add(43);
System.out.println(arrlist);

// 使用迭代器对象遍历
// 生成arrlist的迭代器对象
Iterator<Integer> it = arrlist.iterator();

// 遍历
while (it.hasNext()) {
    Integer val = it.next();
    System.out.println(val);
}
```

## .iterator() 方法

```java
    public Iterator<E> iterator() {
        return new Itr();
    }
```

向外暴露的使用方法，外界通过此方法获取迭代器对象。

规定返回值为 `Iterator<E> ` 类型，Java 中，`Iterator<E> ` 类型是个泛型接口。

该方法直接调用 Itr 类的构造函数，返回了一个 `Iterator<E>` 实例对象。

## Itr() 方法

### 外层声明结构

```java
    private class Itr implements Iterator<E> {...}
```

是个私有实现类，所以要通过向外暴露的 `iterator()` 调用。

它是`Iterator<E> ` 接口的实现类。

### 成员变量

```java
int cursor;       // index of next element to return
int lastRet = -1; // index of last element returned; -1 if no such
int expectedModCount = modCount;
```

1. cursor：可认为是指向接下来要访问元素的滑动指针。
2. lastRet：用来记住上一次所访问元素的指针，也充当一个状态机。
   - 状态为 -1 的时刻：当尚未遍历迭代器或刚刚执行完 .remove() 操作后都会被置为 -1。
   - 1状态为记忆指针的时刻：当执行 .next() 后被赋值，而指向本次已经访问完毕的元素。
3. 版本记录变量：
   - modCount：表示的是**“结构性修改次数”**，本质上就是一个递增计数器当。可以比喻为版本号，当创建完一个 ArrayList 后都会使用 modCount 记录一个版本号，每次List内部结构发生变化时都会更新一个新的版本号，常用 modCount++ 来操作。
   - expectedModCount：记录“迭代器认为正确的结构修改次数”，初始值为创建迭代器那一刻的 `modCount`，之后如果通过 `remove()` 修改 List 时同步更新。

> 为什么使用版本记录变量？
>
> 使用版本记录变量主要是为了在**遍历期间检测任何“非迭代器自身”的结构性修改**，包括：
>
> - 同一线程里用 `list.add/remove` 改结构；
> - 其他线程同时修改。
>    一旦检测到这种“并发修改”（不一定是多线程），就抛出 `ConcurrentModificationException`。

### .hasNext()

```java
public boolean hasNext() {
    return cursor != size;
}

```

用来检验是否还有下一个元素没遍历

size: 为 ArrayList 的长度

### checkForComodification()

```java
final void checkForComodification() {
    if (modCount != expectedModCount)
        throw new ConcurrentModificationException();
}
```

版本控制检测：当 `modCount != expectedModCount` 时，说明 List 发生过结构变化，可能是其他线程更改了结构，与此线程冲突，抛出异常。

### .next()

```java
public E next() {
    // 检测版本号是否相同
    checkForComodification();
    int i = cursor;
    // 检测是否越界
    if (i >= size)
        throw new NoSuchElementException();
    // 检测底层数组是否越界
    Object[] elementData = ArrayList.this.elementData;
    if (i >= elementData.length)
        throw new ConcurrentModificationException();
    // 核心操作：更新 cursor，指向下一次要访问的索引
    cursor = i + 1;
    // 1. lastRet = i	更新记忆指针，记忆本次访问完毕的元素索引
    // 2. (E) elementData[i]	从底层数组中取出索引为i的元素（当前元素），并转换成E类型
    return (E) elementData[lastRet = i];
}
```

功能：取出当前元素，并滑动指针到下一个元素

### .remove()

```java
public void remove() {
    // 1. lastRet 状态为 -1 时：当尚未遍历迭代器或刚刚执行完一次 .remove() 操作后都会被置为 -1。
    // 2. 未执行一次遍历迭代器，当然不可以删除元素；防止重复删除
    if (lastRet < 0)
        throw new IllegalStateException();
    // 检测版本号是否相同
    checkForComodification();

    try {
        // 调用外部类 ArrayList 的 remove 方法删除该位置元素
        ArrayList.this.remove(lastRet);
        // 删除后，后面元素整体前移一位：原下标 lastRet + 1 的元素移动到 lastRet。
        cursor = lastRet;
        // 重置为-1，用来标记刚刚执行完一次删除操作，防止同一索引重复删除，保证一个.next()只能有一次.remove()操作
        lastRet = -1;
        // 删除后，List版本更新，同时更新expectedModCount用来跟进最新版本
        expectedModCount = modCount;
    } catch (IndexOutOfBoundsException ex) {
        throw new ConcurrentModificationException();
    }
}
```