package jdbspractise.controller;

import jdbspractise.web.Request;
import jdbspractise.web.ViewModel;

public class HomeController implements Controller {

    @Override
    public ViewModel process(Request request) {
        ViewModel viewModel = new ViewModel("home");
        return viewModel;
    }
}
