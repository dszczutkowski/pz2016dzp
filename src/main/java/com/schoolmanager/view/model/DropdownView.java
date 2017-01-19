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

    @Inject
    private MessageSender messageSender;

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

  //  @Produces
  //  @Named
    private Message newMessage;


    @PostConstruct
    public void init() {
        HttpSession session = LoginSession.getSession();
        Member m;
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
        newMessage.setText("wiadomość");
        for (Member me : list) {
            if ((me.getFirstName() + " " + me.getLastName()).equals(chosenUser)) {
                newMessage.setReceiverId(me.getId());
            }
        }
            try {
                messageSender.send(newMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    public Map<String, String> getUsers() {
        return users;
    }


}