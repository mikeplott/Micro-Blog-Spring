package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.EmitUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

/**
 * Created by michaelplott on 10/22/16.
 */
@Controller
public class MicroBlogController {
    @Autowired
    MessageRepository messages;
    ReplyRepository replies;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) {
        Iterable<Message> messagelist = messages.findAll();
        model.addAttribute("messages",messagelist);
        return "home";
    }

    @RequestMapping(path = "/message", method = RequestMethod.POST)
    public String addMessage(String text) {
        Message m = new Message(text);
        messages.save(m);
        return "redirect:/";
    }

    @RequestMapping(path = "update-message", method = RequestMethod.GET)
    public String updateMessage(Model model, int id) {
        Message m = messages.findOne(id);
        model.addAttribute("message", m);
        return "update-message";
    }

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String deleteMessage(int id) {
        Message m = messages.findOne(id);
        messages.delete(m);
        return "redirect:/";
    }

    @RequestMapping(path = "/update-message", method = RequestMethod.POST)
    public String updateMessage(int id, String text) {
        Message m = messages.findOne(id);
        messages.delete(m);
        Message mes = new Message(text);
        messages.save(mes);
        return "redirect:/";
    }

    @RequestMapping(path = "/reply", method = RequestMethod.GET)
    public String reply(Model model, int id) {
        ArrayList<Reply> userReplies = new ArrayList<>();
        Iterable<Reply> theReplies = replies.findAll();
        for (Reply reply : theReplies) {
            if (reply.mID == id) {
                userReplies.add(reply);
            }
        }
        model.addAttribute("replies", userReplies);
        return "/replies";
    }
}
