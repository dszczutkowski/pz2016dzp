package com.schoolmanager.view.model;

/**
 * Created by Acer on 2017-01-19.
 */


        import com.schoolmanager.dao.MemberRepository;
        import com.schoolmanager.entity.Member;
        import com.schoolmanager.entity.Message;
        import com.schoolmanager.service.LoginSession;
        import com.schoolmanager.service.MessageSender;
        import org.slf4j.Logger;

        import java.io.Serializable;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;
        import javax.annotation.PostConstruct;
        import javax.enterprise.inject.Model;
        import javax.enterprise.inject.Produces;
        import javax.faces.application.FacesMessage;
        import javax.faces.bean.ManagedBean;
        import javax.faces.bean.ViewScoped;
        import javax.faces.context.FacesContext;
        import javax.inject.Inject;
        import javax.inject.Named;
        import javax.servlet.http.HttpSession;

        import static com.schoolmanager.entity.Member_.login;
@Model
@ManagedBean
@ViewScoped
public class DropdownView implements Serializable {

    public String getChosenUser() {
        return chosenUser;
    }
    private Member m;
    @Inject
    private MessageSender messageSender;

    @Inject
    private FacesContext facesContext;

    @Inject
    private java.util.logging.Logger log;

    public void setChosenUser(String chosenUser) {
        this.chosenUser = chosenUser;
    }

    private String chosenUser;

    private Map<String,String> users;
    private List<Member> list;
    @Inject
    private MemberRepository memberRepository;

    @Produces
    @Named
    private Message newMessage;

    private String messageText;

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    @PostConstruct
    public void init() {
        HttpSession session = LoginSession.getSession();
        m = (Member)session.getAttribute("USERNAME");
        users  = new HashMap<String, String>();
        list = memberRepository.findAllOrderedByName();
        for(Member me : list) {
            if(me.getId() != m.getId())
                users.put(me.getFirstName() + " " + me.getLastName(),me.getFirstName() + " " + me.getLastName());
        }
        newMessage = new Message();
    }

    public void sendButtonClick() {
        newMessage.setText(messageText);
        newMessage.setReceiverId((long) 0);
        for (Member me : list) {
            if ((me.getFirstName() + " " + me.getLastName()).equals(chosenUser)) {
                newMessage.setReceiverId(me.getId());
            }
        }
        if (newMessage.getReceiverId() == 0) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Wybierz do kogo wyslac wiadomosc!", "Nie wybrano odbiorcy");
            facesContext.addMessage(null, msg);
        } else {
            newMessage.setSenderId(m.getId());
            try {
                messageSender.send(newMessage);
                FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Wyslano!", "Wyslano wiadomosc");
                facesContext.addMessage(null, m);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Map<String, String> getUsers() {
        return users;
    }


}