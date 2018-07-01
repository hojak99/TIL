package com.kjh.hojak.snake;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.awt.*;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class SnakeWebSocketHandler extends TextWebSocketHandler {

    public static final int PLAYFIELD_WIDTH = 640;
    public static final int PLAYFIELD_HEIGHT = 480;
    public static final int GRID_SIZE = 10;

    private static final AtomicInteger snakeIds = new AtomicInteger(0);
    private static final Random random = new Random();

    private final int id;
    private Snake snake;

    public SnakeWebSocketHandler() {
        this.id = snakeIds.getAndIncrement();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        this.snake = new Snake(this.id, session);
        SnakeTimer.addSnake(this.snake);
        StringBuilder sb = new StringBuilder();

        for(Iterator<Snake> iterator = SnakeTimer.getSnakes().iterator(); iterator.hasNext();) {
            Snake snake = iterator.next();
            sb.append(String.format("{id: %d, color: '%s'}", Integer.valueOf(snake.getId()), snake.getHexColor()));

            if(iterator.hasNext()) {
                sb.append(',');
            }
        }
        SnakeTimer
                .broadcast(String.format("{'type' : 'join', 'data' : [%s]}", sb.toString()));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();

        if("west".equals(payload)) {
            this.snake.setDirection(Direction.WEST);
        }
        else if("north".equals(payload)) {
            this.snake.setDirection(Direction.NORTH);
        }
        else if("east".equals(payload)) {
            this.snake.setDirection(Direction.EAST);
        }
        else if("south".equals(payload)) {
            this.snake.setDirection(Direction.SOUTH);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        SnakeTimer.removeSnake(this.snake);
        SnakeTimer.broadcast(
                String.format("{'type': 'leave', 'id': %d}", Integer.valueOf(this.id)));
    }
}
