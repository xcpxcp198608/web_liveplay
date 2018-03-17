package com.wiatec.liveplay.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;

/**
 * @author patrick
 */
public class EmailMaster {

	private static final Logger logger = LoggerFactory.getLogger(EmailMaster.class);

	private static final String LD_SEND_ADDRESS = "bactivation@legacy.direct";
	private static final String LD_USERNAME = "bactivation@legacy.direct";
	private static final String LD_PASSWORD ="Ihatespam123#";

	private static final String LDE_SEND_ADDRESS = "activation@ldeufonico.com";
	private static final String LDE_USERNAME = "activation@ldeufonico.com";
	private static final String LDE_PASSWORD ="Wangwang777#";

	public static final int SEND_FROM_LD = 101;
	public static final int SEND_FROM_LDE = 102;

	private String emailSubject = "WELCOME TO LD";
	private String emailContent = "";

	private Properties properties;
	private Session session;
	private MimeMessage message;
	private Transport transport = null;

	private MimeMultipart msgMultipart = null;
	private MimeBodyPart attachmentPart = null;

	private int sender = 101;

	public EmailMaster(int sender) {
		properties = new Properties();
		properties.setProperty("mail.smtp.host","smtp.office365.com") ;
		properties.setProperty("mail.smtp.port","587") ;
		properties.put("mail.smtp.starttls.enable","true");
		properties.setProperty("mail.smtp.socketFactory.port","587") ;
		properties.setProperty("mail.smtp.auth","true") ;
		session = Session.getDefaultInstance(properties, null);
		message = new MimeMessage(session);
		msgMultipart = new MimeMultipart("mixed");
		this.sender = sender;
	}

	public void setEmailSubject(String subject){
		this.emailSubject = subject;
	}

	public void setEmailContent(String basePath, String userName ,String token, String language){
		StringBuilder stringBuilder = new StringBuilder();
		if("Spanish".equals(language)){
			stringBuilder.append("Dear "+userName+":<br/>");
			stringBuilder.append("<br/>");
			stringBuilder.append("BTVi3 de Legacy Direct"+"<br/>");
			stringBuilder.append("Damos gracias por registrar su BTVi3."+"<br/>");
			stringBuilder.append("Para finalizar su afiliación, por favor presione el botón de abajo para activar su cuenta "+"<br/><br/>");
			stringBuilder.append("<a href='" + basePath + "/activate/"+token+"'>" +
					"ACTIVATE MY ACCOUNT</a>"+"<br/><br/>");
			stringBuilder.append("Si tienes alguna pregunta o algún problema, nuestro equipo de soporte support@legacy.direct estará ahí para asistirlo."+"<br/><br/>");
			stringBuilder.append("Legacy Direct"+"<br/>");
		}else if("Chinese".equals(language)){
			stringBuilder.append("亲爱的 "+userName+":<br/>");
			stringBuilder.append("<br/>");
			stringBuilder.append("BTVi3 by Legacy Direct"+"<br/>");
			stringBuilder.append("感谢您的注册"+"<br/>");
			stringBuilder.append("请点击下方的激活按钮完成您的注册"+"<br/><br/>");
			stringBuilder.append("<a href='" + basePath + "/activate/"+token+"'>" +
					"激活</a>"+"<br/><br/>");
			stringBuilder.append("如果您有任何问题，请联系 support@legacy.direct 我们会很高兴为您服务"+"<br/><br/>");
			stringBuilder.append("Legacy Direct"+"<br/>");
		}else if("French".equals(language)){
			stringBuilder.append("Dear "+userName+":<br/>");
			stringBuilder.append("<br/>");
			stringBuilder.append("BTVi3 par Legacy Direct"+"<br/>");
			stringBuilder.append("Nous vous remercions de votre enregistrement sur BTVi3."+"<br/>");
			stringBuilder.append("Pour terminer votre inscription,  veuillez activer votre compte en cliquant sur le bouton ci-dessous:"+"<br/><br/>");
			stringBuilder.append("<a href='" + basePath + "/activate/"+token+"'>" +
					"ACTIVER MON COMPTE</a>"+"<br/><br/>");
			stringBuilder.append("Si vous avez des questions ou vous rencontrez des problèmes, veuillez contacter notre équipe d'assistance qui est heureuse de vous aider : support@legacy.direct " +
					"Vous pouvez également visiter notre Centre d’assistance (Support Desk)."+"<br/><br/>");
			stringBuilder.append("Legacy Direct"+"<br/>");
		}else if("Italian".equals(language)){
			stringBuilder.append("Dear "+userName+":<br/>");
			stringBuilder.append("<br/>");
			stringBuilder.append("BTVi3 by Legacy Direct"+"<br/>");
			stringBuilder.append("Grazie per aver registrato il Vostro prodotto BTVi3."+"<br/>");
			stringBuilder.append("Per completare il processo di attivazione, per cortesia cliccate sul link di seguito per finalizzare l'attivazione del Vostro account."+"<br/><br/>");
			stringBuilder.append("<a href='" + basePath + "/activate/"+token+"'>" +
					"ACTIVATE MY ACCOUNT</a>"+"<br/><br/>");
			stringBuilder.append("Per qualsiasi altra domanda o se avete qualsiasi dubbio e/o problema, il nostro team di supporto sará felice di fornirvi qualsiasi risposta attraverso la mail  support@legacy.direct " +
					"In alternativa potete visitare il nostro Support Desk."+"<br/><br/>");
			stringBuilder.append("Legacy Direct"+"<br/>");
		}else if("German".equals(language)){
			stringBuilder.append("Dear "+userName+":<br/>");
			stringBuilder.append("<br/>");
			stringBuilder.append("BTVi3 von Legacy Direct"+"<br/>");
			stringBuilder.append("Vielen Dank für die Registrierung Ihres BTVi3-Gerätes."+"<br/>");
			stringBuilder.append("Um das Anmelden zu beenden, klicken Sie bitte auf die Taste unten, um Ihr Konto zu aktivieren."+"<br/><br/>");
			stringBuilder.append("<a href='" + basePath + "/activate/"+token+"'>" +
					"KTIVIEREN SIE MEIN KONTO</a>"+"<br/><br/>");
			stringBuilder.append("Wenn Sie Fragen oder Anregungen haben, steht Ihnen unser Support-Team unter support@legacy.direct gerne zur Verfügung. Alternativ können Sie unser Support Desk besuchen. "+"<br/><br/>");
			stringBuilder.append("Legacy Direct"+"<br/>");
		}else if("Slovakia".equals(language)){
			stringBuilder.append("Dear "+userName+":<br/>");
			stringBuilder.append("<br/>");
			stringBuilder.append("BTVi3 od spoločnosti Legacy Direct"+"<br/>");
			stringBuilder.append("Ďakujeme za registráciu Vášho BTVi3."+"<br/>");
			stringBuilder.append("Ak chcete dokončiť proces registrácie, kliknutím na tlačidlo nižšie aktivujte svoj účet"+"<br/><br/>");
			stringBuilder.append("<a href='" + basePath + "/activate/"+token+"'>" +
					"AKTIVOVAŤ MÔJ ÚČET</a>"+"<br/><br/>");
			stringBuilder.append("Ak máte akékoľvek otázky alebo ak máte problémy, kontaktujte náš tím podpory nasupport@legacy.direct, ktorý Vám rád pomôže. Prípadne môžete kontaktovať náš Support Desk."+"<br/><br/>");
			stringBuilder.append("Legacy Direct"+"<br/>");
		}else if("Czech".equals(language)){
			stringBuilder.append("Dear "+userName+":<br/>");
			stringBuilder.append("<br/>");
			stringBuilder.append("BTVi3 od společnosti Legacy Direct"+"<br/>");
			stringBuilder.append("Děkujeme, že jste zaregistrovali svůj BTVi3."+"<br/>");
			stringBuilder.append("Chcete-li dokončit proces registrace, klikněte na tlačítko níže a aktivujte svůj účet"+"<br/><br/>");
			stringBuilder.append("<a href='" + basePath + "/activate/"+token+"'>" +
					"AKTIVOVAT MŮJ ÚČET</a>"+"<br/><br/>");
			stringBuilder.append("Pokud máte nějaké dotazy nebo máte problémy, náš tým podpory na adrese support@legacy.directVám rád pomůže. Případně můžete navštívit naš Support Desk."+"<br/><br/>");
			stringBuilder.append("Legacy Direct"+"<br/>");
		}else if("Romania".equals(language)){
			stringBuilder.append("Dear "+userName+":<br/>");
			stringBuilder.append("<br/>");
			stringBuilder.append("BTVi3 de către Legacy Direct"+"<br/>");
			stringBuilder.append("Vă mulțumim că ați înregistrat BTVi3."+"<br/>");
			stringBuilder.append("Pentru a finaliza procesul de înscriere, vă rugăm să faceți clic pe butonul de mai jos pentru a vă activa contul"+"<br/><br/>");
			stringBuilder.append("<a href='" + basePath + "/activate/"+token+"'>" +
					"ACTIVEAZĂ CONTUL MEU</a>"+"<br/><br/>");
			stringBuilder.append("Dacă aveți întrebări sau dacă întâmpinați probleme, echipa noastră de suport la support@legacy.direct vă asistă cu plăcere. Alternativ, puteți vizita Support Desk."+"<br/><br/>");
			stringBuilder.append("Legacy Direct"+"<br/>");
		}else{
			stringBuilder.append("Dear "+userName+":<br/>");
			stringBuilder.append("<br/>");
			stringBuilder.append("BTVi3 by Legacy Direct"+"<br/>");
			stringBuilder.append("Congratulations! You have successfully registered your BTVi3."+"<br/>");
			stringBuilder.append("You can now enjoy the many benefits and features that come with your BTVi3. As a BONUS we would like to extend to you a FREE 7 DAY TRIAL TO MY VIP EXPERIENCE so that you can experience the benefits including  NO ADS and access to MY VIP EXPERIENCE SECTION."+"<br/><br/>");
			stringBuilder.append("We know that you will enjoy it. Try it today!"+"<br/><br/>");
			stringBuilder.append("<a href='" + basePath + "/activate/"+token+"'>" +
					"ACTIVATE MY ACCOUNT</a>"+"<br/><br/>");
			stringBuilder.append("If you have any questions or if you’re encountering problems, our support team at support@legacy.direct is happy to assist you. Alternatively you can visit our Support Desk."+"<br/><br/>");
			stringBuilder.append("Legacy Direct"+"<br/>");
		}
		this.emailContent = stringBuilder.toString();
	}

	public void setResetPasswordContent(String basePath, String userName ,String token){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Dear "+userName+":<br/>");
		stringBuilder.append("<br/>");
		stringBuilder.append("Legacy Direct"+"<br/>");
		stringBuilder.append("You have requested to reset your password.  " +
				"Please click the link below to finalize the process."+"<br/><br/>");
		stringBuilder.append("<a href='" + basePath + "/reset/"+token+"'>" +
				"RESET PASSWORD</a>"+"<br/><br/>");
		stringBuilder.append("Legacy Direct"+"<br/>");
		this.emailContent = stringBuilder.toString();
	}

	public void setInvoiceContent(String userName){
		setEmailSubject("WELCOME TO LDEUFONIC");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Dear "+userName+":<br/>");
		stringBuilder.append("<br/>");
		stringBuilder.append("Please check the attachment to view your invoice!"+"<br/>");
		this.emailContent = stringBuilder.toString();
	}

	public boolean sendMessage(String receiverAddress){
		if(TextUtil.isEmpty(receiverAddress)){
			System.out.println("receiverAddress error");
			return false;
		}
		try {
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiverAddress));
			switch (sender){
				case SEND_FROM_LD:
					message.setFrom(new InternetAddress(LD_SEND_ADDRESS));
					break;
				case SEND_FROM_LDE:
					message.setFrom(new InternetAddress(LDE_SEND_ADDRESS));
					break;
				default:
					message.setFrom(new InternetAddress(LD_SEND_ADDRESS));
					break;
			}
			message.setSubject(emailSubject);
			message.setContent(msgMultipart);

			MimeBodyPart content = new MimeBodyPart();
			content.setContent(emailContent,"text/html ; charset=utf-8");
			msgMultipart.addBodyPart(content);
			if(attachmentPart != null){
				msgMultipart.addBodyPart(attachmentPart);
			}
			message.setSentDate(new Date());
			message.saveChanges();
			transport = session.getTransport("smtp");
			switch (sender){
				case SEND_FROM_LD:
					transport.connect((String)properties.get("mail.smtp.host"), LD_USERNAME ,LD_PASSWORD);
					break;
				case SEND_FROM_LDE:
					transport.connect((String)properties.get("mail.smtp.host"), LDE_USERNAME ,LDE_PASSWORD);
					break;
				default:
					transport.connect((String)properties.get("mail.smtp.host"), LD_USERNAME ,LD_PASSWORD);
					break;
			}
			transport.sendMessage(message , message.getRecipients(MimeMessage.RecipientType.TO));
			return true;
		} catch (MessagingException e) {
			logger.error(e.getLocalizedMessage());
			return false;
		}finally{
			try {
				if(transport != null){
					transport.close();
				}
			} catch (MessagingException e) {
				logger.error(e.getLocalizedMessage());
			}
		}
	}

	public void addAttachment(String path){
		try {
			attachmentPart = new MimeBodyPart();
			FileDataSource fds = new FileDataSource(path);
			attachmentPart.setDataHandler(new DataHandler(fds));
			String[] f = path.split("/");
			String fileName = f[f.length - 1];
			attachmentPart.setFileName(fileName);
		} catch (MessagingException e) {
			logger.error(e.getLocalizedMessage());
		}
	}

	public static void main (String [] args){
		EmailMaster emailMaster = new EmailMaster(SEND_FROM_LDE);
		emailMaster.setEmailContent("sf", "sdfsf", "sdfsdf", "sdfsd");
		emailMaster.sendMessage("patrickxu@wiatec.com");
	}


}
