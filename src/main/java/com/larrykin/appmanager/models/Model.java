package com.larrykin.appmanager.models;

import com.larrykin.appmanager.views.ViewFactory;

public class Model {
    //? Initializing the Model and the ViewFactory
    private static Model model;
    private final ViewFactory viewFactory;

    //?constructor
    public Model() {
        this.viewFactory = new ViewFactory();
    }

    //? Singleton pattern to ensure only one instance of the Model is created
    public static synchronized  Model getInstance(){
        if (model == null){
            model = new Model();
        }
        return model;
    }
    //?getter for the viewFactory to be used in the controller
    public ViewFactory getViewFactory() {
        return viewFactory;
    }
}
