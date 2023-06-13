package com.kosta.openday.user.controller;


import java.util.Random;

import javax.mail.internet.MimeMessage;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.openday.user.dto.UserDTO;
import com.kosta.openday.user.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;

	@Autowired
	private JavaMailSenderImpl mailSender;

	@RequestMapping(value = "/findid", method = RequestMethod.GET)
	public String findId() {
		return "/login/findId";
	}

	@RequestMapping(value = "/findpw", method = RequestMethod.GET)
	public String findPw() {
		return "/login/findPw";
	}

	@RequestMapping(value = "/idconfirm", method = RequestMethod.GET)
	public String idConfirm() {
		return "/login/idConfirm";
	}

	@RequestMapping(value = "/findid", method = RequestMethod.POST)
	public ModelAndView getUserFindId(@RequestParam("userEmail") String userEmail) {
		ModelAndView mav = new ModelAndView();
		try {

			UserDTO findId = userService.getUserFindId(userEmail);
			mav.addObject("findId", findId);
			mav.setViewName("/login/idConfirm");

		} catch (Exception e) {
			e.printStackTrace();

		}
		return mav;
	}

	@RequestMapping(value = "/findpw", method = RequestMethod.POST)
	public ModelAndView getUserFindPw(@RequestParam("userId") String userId) {
		ModelAndView mav = new ModelAndView();

		try {

			UserDTO user = userService.getUserInfo(userId);
			if (user == null)
				throw new Exception("not id exist");

			String tempPassword = getTempPassword(10);
			System.out.println(tempPassword);
			user.setUserPassword(tempPassword);

			userService.resetPassword(user);

			mav.addObject("userName", user.getUserName());
			mav.addObject("tempPassword", tempPassword);
			mav.setViewName("/login/pwConfirm");

		} catch (Exception e) {
			e.printStackTrace();

		}

		return mav;

	}

	private String getTempPassword(int leng) {
		int index = 0;
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a',
				'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z' }; // 배열안의 문자 숫자는 원하는대로

		StringBuffer password = new StringBuffer();
		Random random = new Random();

		for (int i = 0; i < leng; i++) {
			double rd = random.nextDouble();
			index = (int) (charSet.length * rd);

			password.append(charSet[index]);
		}

		System.out.println(password.toString());
		return password.toString();
		// StringBuffer를 String으로 변환해서 return 하려면 toString()을 사용하면 된다.
	}

	@RequestMapping(value = "/mailCheck", method = RequestMethod.POST)
	@ResponseBody
	public String mailCheck(@RequestParam("userId") String userId, @RequestParam("sm_email") String sm_email) {

		String num = "";
		try {
			UserDTO user = userService.getUserFindPw(userId, sm_email);
			if (user == null) {
				throw new Exception("id not exist");
			}
			int serti = (int) ((Math.random() * (99999 - 10000 + 1)) + 10000);
			/* System.out.println(sm_email); */
			String from = "opendaynday@naver.com";// 보내는 이 메일주소
			String to = sm_email;
			String title = "비밀번호를 찾기 위해 필요한 인증번호 입니다.";
			String content = "[인증번호] " + serti + " 입니다. <br/> 인증번호 확인란에 기입해주십시오.";
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
			mailHelper.setFrom(from);
			mailHelper.setTo(to);
			mailHelper.setSubject(title);
			mailHelper.setText(content, true);
			mailSender.send(mail);
			num = Integer.toString(serti);
		} catch (Exception e) {
			num = "error";
		}
		return num;
	}

	@RequestMapping(value = "/emailChkForId", method = RequestMethod.POST)
	@ResponseBody
	public String idFindMailCheck(@RequestParam("userEmail") String userEmail) {

		String num = "";
		try {
			UserDTO user = userService.getUserFindId(userEmail);
			if (user == null) {
				throw new Exception("email not exist");
			}
			int serti = (int) ((Math.random() * (99999 - 10000 + 1)) + 10000);
			String from = "opendaynday@naver.com";// 보내는 이 메일주소
			String to = userEmail;
			String title = "아이디를 찾기 위해 필요한 인증번호 입니다.";
			String content = "[인증번호] " + serti + " 입니다. <br/> 인증번호 확인란에 기입해주십시오.";
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
			mailHelper.setFrom(from);
			mailHelper.setTo(to);
			mailHelper.setSubject(title);
			mailHelper.setText(content, true);
			mailSender.send(mail);
			num = Integer.toString(serti);
		} catch (Exception e) {
			num = "error";
		}
		return num;
	}

	/*
	 * @RequestMapping(value="findpw", method=RequestMethod.POST) public
	 * ModelAndView getUserFindPw(@RequestParam("userId") String
	 * userId,@RequestParam("userEmail") String userEmail) { ModelAndView mav = new
	 * ModelAndView(); } try { UserDTO user = userService.getUserFindPw(userId,
	 * userEmail); if (user != null) { // If user exists, generate a new password
	 * String newPassword = UUID.randomUUID().toString().substring(0, 8); // Or use
	 * a better password generation method user.setPassword(newPassword);
	 * userService.getResetPassword(user);
	 * 
	 * // TODO: Send the new password to user's email. This is beyond the scope of
	 * this example.
	 * 
	 * mav.addObject("message", "A new password has been sent to your email.");
	 * mav.setViewName("pwConfirm"); // Or wherever you want to redirect } else {
	 * mav.addObject("message", "No account found with that email address.");
	 * mav.setViewName("findPw"); // Or wherever you want to redirect }
	 * 
	 * 
	 * } catch (Exception e) { e.printStackTrace();
	 * 
	 * } return mav; }
	 */

}
