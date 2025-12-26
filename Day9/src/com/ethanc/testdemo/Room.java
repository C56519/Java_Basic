package com.ethanc.testdemo;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class Room {
    public static void start() {
        // 一、制作牌
        // 1. 定义数组，存储全部点数和花色
        String[] points = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        String[] colors = {"♠", "♥", "♣", "♦"};
        // 每张牌的权重
        int weight = 0;

        // 2. 创建一个ArrayList集合存储全部卡牌，结合花色和点数后存储牌，并设置权重
        List<Card> allCards = new ArrayList<>();
        for (String p : points) {
            // 遍历点数时，自动权重自加
            weight++;
            for (String c:  colors) {
                // 创建卡片对象
                Card card = new Card(p, c, weight);
                // 将卡片添加到集合中
                allCards.add(card);
            }
        }
        // 3. 添加大小王卡片到全部卡牌集合中
        Collections.addAll(allCards, new Card("", "🐈‍⬛", ++weight), new Card("", "🃏", ++weight));
        System.out.println("全部卡牌：" + allCards);

        // 二、洗牌
        Collections.shuffle(allCards, new Random(42));  // 设置随机种子
        System.out.println("洗牌后：" + allCards);

        // 三、发牌
        // 三个人，每轮给每一人发一张牌，最后留出地主的三张底牌
        // 这里使用Map集合，键为玩家，值为所拥有牌的集合
        // 1. 创建本局游戏分好牌后的牌库
        Map<String, List<Card>> playerLib = new HashMap<>();
        // 2. 创建三个玩家各自的牌库，并添加到Map集合中
        List<Card> player1Cards = new ArrayList<>();
        playerLib.put("玩家1", player1Cards);
        List<Card> player2Cards = new ArrayList<>();
        playerLib.put("玩家2", player2Cards);
        List<Card> player3Cards = new ArrayList<>();
        playerLib.put("玩家3", player3Cards);
        // 3. 分牌
        for (int i = 0; i < allCards.size() - 3; i++) {
            Card card = allCards.get(i);
            if (i % 3 == 0) {
                // 发给玩家1
                player3Cards.add(card);
            } else if (i % 3 == 1) {
                // 发给玩家2
                player2Cards.add(card);
            } else {
                // 发给玩家3
                player1Cards.add(card);
            }
        }
        // 4. 将底牌存到集合备用
        List<Card> leftCards = allCards.subList(allCards.size() - 3, allCards.size());
        System.out.println("底牌：" + leftCards);

        // 四、对牌排序
        sortCards(player1Cards);
        sortCards(player2Cards);
        sortCards(player3Cards);

        // 五、看牌
        // 遍历Map集合，分别打印三个玩家牌库
        for (Map.Entry<String, List<Card>> entry : playerLib.entrySet()) {
            String playerName = entry.getKey();
            List<Card> playerCards = entry.getValue();
            System.out.println(playerName + "的牌：" + playerCards);
        }
    }

    /**
     * 对牌进行排序
     * @param cards 个人牌库类型
     */
    public static void sortCards(List<Card> cards) {
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                // 降序
                return o2.getWeight() - o1.getWeight();
            }
        });
    }
}
