package com.dyn.login.gui;

import com.dyn.login.LoginGUI;
import com.rabbit.gui.background.DefaultBackground;
import com.rabbit.gui.component.control.Button;
import com.rabbit.gui.component.control.TextBox;
import com.rabbit.gui.component.display.TextLabel;
import com.rabbit.gui.render.TextAlignment;
import com.rabbit.gui.show.Show;

public class Login extends Show {

	private String username;
	private String password;

	public Login() {
		this.setBackground(new DefaultBackground());
		this.title = "City of Learning Login";
	}

	@Override
	public void setup() {
		super.setup();

		this.registerComponent(new TextLabel((int) (this.width * .6), (int) (this.height * .05), this.width / 3, 20,
				"Loan Account Login", TextAlignment.CENTER));

		this.registerComponent(new Button((int) (this.width * .9), (int) (this.height * .04), 20, 15, ">>")
				.setClickListener(but -> this.getStage().display(new Checkout())));

		this.registerComponent(new TextLabel(this.width / 6, (int) (this.height * .325), this.width / 3, 20,
				"City of Learning Login", TextAlignment.LEFT));

		this.registerComponent(new Button((int) (this.width * .7), (int) (this.height * .55), 50, 20, "Login")
				.setClickListener(but -> loginPressed()));

		this.registerComponent(new TextBox((int) (this.width * .15), (int) (this.height * .4), 200, 20, "username")
				.setTextChangedListener((TextBox textbox, String previousText) -> textChanged(textbox, previousText))
				.setId("username"));

		this.registerComponent(new TextBox((int) (this.width * .15), (int) (this.height * .55), 200, 20, "password")
				.setTextChangedListener((TextBox textbox, String previousText) -> textChanged(textbox, previousText))
				.setId("password"));

	}

	public void textChanged(TextBox textbox, String previousText) {
		if (textbox.getId() == "username") {
			username = previousText;
		} else if (textbox.getId() == "password") {
			password = previousText;
		}
	}

	public void loginPressed() {
		// this is where the http request should happen, should probably thread
		// it
		
		//if the login is successful it should set the variables
		LoginGUI.DYN_Username = username;
		LoginGUI.DYN_Password = password;
		this.stage.close();
	}
}
