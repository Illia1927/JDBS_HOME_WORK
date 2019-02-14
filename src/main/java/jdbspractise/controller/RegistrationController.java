package jdbspractise.controller;

import jdbspractise.web.ViewModel;

public class RegistrationController implements Controller {
    @Override
    public ViewModel process() {
        ViewModel viewModel = new ViewModel("registration");
        return viewModel;
    }
}
