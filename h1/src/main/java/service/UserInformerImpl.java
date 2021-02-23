package service;

import model.User;

public class UserInformerImpl implements UserInformer {
    private User user;
    private final IOService ioService;

    public UserInformerImpl(IOService ioService) {
        this.ioService = ioService;
    }

    @Override
    public void run() {
        ioService.write("Name");
        String name = ioService.read();

        ioService.write("Surname");
        String surName = ioService.read();
        user = new User(name, surName);
    }

    @Override
    public User getUser() {
        return user;
    }
}
