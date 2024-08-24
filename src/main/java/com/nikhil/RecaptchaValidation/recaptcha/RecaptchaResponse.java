package com.nikhil.RecaptchaValidation.recaptcha;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecaptchaResponse {


    private boolean success;
	private String challenge_ts;
	private String hostname;
     

}
