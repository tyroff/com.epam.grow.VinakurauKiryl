package examples.multithreading.sinchronizers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Exchanger;

public class ExchangerSample {

    public static void main(String[] args) {
        Exchanger<Message> exchanger = new Exchanger<>();
        Thread thread1 = new Job(exchanger);
        Thread thread2 = new Job(exchanger);

        thread1.start();
        thread2.start();
    }
}

class Message {

    public String header;
    public String body;

    public Message(String header, String body) {
        this.header = header;
        this.body = body;
    }
}

class Job extends Thread {
    Exchanger<Message> messageExchanger;
    Queue<Message> queue = new LinkedList<>();

    public Job(Exchanger<Message> messageExchanger) {
        this.messageExchanger = messageExchanger;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            String header = this.getName() + " #" + i + " encode fdj23rtjnoi89" + i;
            String body = "fjavocahinbldds";
            queue.offer(new Message(header, body));
        }

        try {
            final Message message1 = messageExchanger.exchange(queue.poll());
            System.out.println(this.getName() + " exchange message " + message1.header);

            final Message message2 = messageExchanger.exchange(queue.poll());
            System.out.println(this.getName() + " exchange message " + message2.header);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
