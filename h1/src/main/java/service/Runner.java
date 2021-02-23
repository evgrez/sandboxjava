package service;

public class Runner {
    private final IOService ioService;
    private final UserInformer userInformer;
    private final Testing testing;

    public Runner(IOService ioService, UserInformer userInformer, Testing testing) {
        this.ioService = ioService;
        this.userInformer = userInformer;
        this.testing = testing;
    }

    public void run(){
        ioService.write("Hello");
        userInformer.run();
        if (userInformer.getUser() != null){
            String name = userInformer.getUser().getName();
            ioService.write("So, " + name);
            testing.run();
        }
        ioService.write("Goodbye");
    }
}
