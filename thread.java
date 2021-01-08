class Hi extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hi");
            try {Thread.sleep(500);} catch (InterruptedException e) {}
        }
    }
}

class Hello extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello");
            try {Thread.sleep(500);} catch (InterruptedException e) {}
        }
    }
}
class thread{
    public static void main(String[] args) throws IllegalArgumentException, InterruptedException {
        Hi obj1 = new Hi();
        Hello obj2 = new Hello();
        obj1.start();
        try {Thread.sleep(10);} catch (InterruptedException e) {}
        obj2.start();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hi");
                try {Thread.sleep(500);} catch (InterruptedException e) {}
            }
        },"Hi Thread");

        t1.start();
    }
}
