package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DataDiriController {

    @GetMapping(value = "/form")
    public ModelAndView form(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("form");
        return mav;
    }

    @PostMapping(value = "/post-data")
    public ModelAndView post_data(@ModelAttribute("data_diri") DataDiri dataDiri){
        ModelAndView mav = new ModelAndView();
        DataDiriImpl dataDiriImpl = new DataDiriImpl();
        dataDiriImpl.InsertData(dataDiri);
        mav.setViewName("redirect:/form");
        return mav;
    }

    @GetMapping(value = "/data")
    public ModelAndView data(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("show-data");
        DataDiriImpl dataDiriImpl = new DataDiriImpl();
        List<DataDiri> dataDiriList = new ArrayList<>();
        dataDiriList = dataDiriImpl.GetAllData();
        mav.addObject("dataDiriList", dataDiriList);
        return mav;
    }

    @GetMapping(value = "/details/{id}")
    public ModelAndView details(@PathVariable("id") int id){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("details");
        DataDiriImpl dataDiriImpl = new DataDiriImpl();
        List<DataDiri> dataDiriList = new ArrayList<>();
        dataDiriList = dataDiriImpl.GetOneData(id);
        mav.addObject("dataDiriList", dataDiriList);
        return mav;
    }

    @GetMapping(value = "/nama/{id}")
    public ModelAndView nama(@PathVariable("id") int id){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("nama");
        DataDiriImpl dataDiriImpl = new DataDiriImpl();
        String nama = dataDiriImpl.GetNameById(id);
        mav.addObject("nama", nama);
        return mav;
    }

    @PostMapping(value = "/update")
    public ModelAndView update(@ModelAttribute("data_diri") DataDiri dataDiri){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/data");
        DataDiriImpl dataDiriImpl = new DataDiriImpl();
        dataDiriImpl.Update(dataDiri);
        return mav;
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") int id){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/data");
        DataDiriImpl dataDiriImpl = new DataDiriImpl();
        dataDiriImpl.Delete(id);
        return mav;
    }
}
