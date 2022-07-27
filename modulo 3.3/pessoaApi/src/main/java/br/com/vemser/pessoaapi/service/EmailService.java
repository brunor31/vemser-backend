package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;
    @Value("${spring.mail.username}")
    private String from;
    private final JavaMailSender emailSender;
    @Autowired
    private ObjectMapper objectMapper;

    public void sendEmailPessoaCreate(PessoaDTO pessoaDTO) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo("bruno.rodrigues@dbccompany.com.br");
        message.setSubject("Assunto 1");
        message.setText("Olá, " + pessoaDTO.getNome() +
                "\nEstamos muito felizes em ter você em nosso sitema :)" +
                "\nSeu cadastro foi realizado com sucesso, seu identificador é id: " + pessoaDTO.getIdPessoa() +
                "\nQualquer dúvida é contatar o suporte pelo e-mail " + from +
                "\nAtt," +
                "\nSistema.");
        emailSender.send(message);
    }

    public void sendEmailPessoaUpdate(PessoaDTO pessoaDTO) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo("bruno.rodrigues@dbccompany.com.br");
        message.setSubject("Assunto 2");
        message.setText("Olá, " + pessoaDTO.getNome() +
                "\nSeus dados foram atualizados em nosso sistema :)" +
                "\nQualquer dúvida é contatar o suporte pelo e-mail " + from +
                "\nAtt," +
                "\nSistema.");
        emailSender.send(message);
    }

    public void sendEmailPessoaDelete(PessoaEntity pessoaEntity) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo("bruno.rodrigues@dbccompany.com.br");
        message.setSubject("Assunto 3");
        message.setText("Olá, " + pessoaEntity.getNome() +
                "\nVocê perdeu acesso ao nosso sistema." +
                "\nQualquer dúvida é contatar o suporte pelo e-mail " + from +
                "\nAtt," +
                "\nSistema.");
        emailSender.send(message);
    }

    public void sendEmailCreateEndereco(EnderecoDTO enderecoDTO, PessoaDTO pessoaDTO) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaDTO.getEmail());
            mimeMessageHelper.setSubject("Assunto 4");
            mimeMessageHelper.setText(getContentFromTemplateCreate(enderecoDTO, pessoaDTO), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }

    }
    public String getContentFromTemplateCreate(EnderecoDTO enderecoDTO, PessoaDTO pessoaDTO) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaDTO.getNome());
        dados.put("id", enderecoDTO.getIdEndereco());
        dados.put("email", from);

        Template template = fmConfiguration.getTemplate("email-template.create.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }
    public void sendEmailUpdateEndereco(EnderecoDTO enderecoDTO, PessoaDTO pessoaDTO) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaDTO.getEmail());
            mimeMessageHelper.setSubject("Assunto 4");
            mimeMessageHelper.setText(getContentFromTemplateUpdate(enderecoDTO, pessoaDTO), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }

    }
    public String getContentFromTemplateUpdate(EnderecoDTO enderecoDTO, PessoaDTO pessoaDTO) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaDTO.getNome());
        dados.put("id", enderecoDTO.getIdEndereco());
        dados.put("email", from);

        Template template = fmConfiguration.getTemplate("email-template.update.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }
    public void sendEmailDeleteEndereco(EnderecoEntity enderecoEntity, PessoaEntity pessoaEntity) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaEntity.getEmail());
            mimeMessageHelper.setSubject("Assunto 4");
            mimeMessageHelper.setText(getContentFromTemplateDelete(enderecoEntity, pessoaEntity), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }

    }
    public String getContentFromTemplateDelete(EnderecoEntity enderecoEntity, PessoaEntity pessoaEntity) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaEntity.getNome());
        dados.put("id", enderecoEntity.getIdEndereco());
        dados.put("email", from);

        Template template = fmConfiguration.getTemplate("email-template.delete.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }
}

