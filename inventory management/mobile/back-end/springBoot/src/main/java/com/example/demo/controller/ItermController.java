package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Details;
import com.example.demo.entity.Iterm;
import com.example.demo.repository.DetailsRepository;
import com.example.demo.repository.ItermRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ItermController {
    @Autowired
    private ItermRepository itermRepository;
    @Autowired
    private DetailsRepository detailsRepository;

    @ResponseBody
    @PostMapping(value = "add",produces = "application/json;charset=UTF-8")
    public void addDate(@RequestBody JSONObject data){
        Iterm iterm=new Iterm();
        Details details=new Details();
        JSONObject itermJson= data.getJSONObject("data");

        details.setWarehouse(itermJson.getString("warehouse"));
        details.setBrand(itermJson.getString("brand"));
        details.setCategory(itermJson.getString("category"));
        details.setModel(itermJson.getString("model"));
        details.setNum(Integer.valueOf(itermJson.getString("num")));
        details.setOperator("manager");
        details.setOperation("enter");
        detailsRepository.save(details);

        System.out.println(itermJson);
        System.out.println(itermJson.getString("warehouse"));
        iterm.setWarehouse(itermJson.getString("warehouse"));
        iterm.setBrand(itermJson.getString("brand"));
        iterm.setCategory(itermJson.getString("category"));
        iterm.setModel(itermJson.getString("model"));
        iterm.setNum(Integer.valueOf(itermJson.getString("num")));

        itermRepository.save(iterm);
    }

    @RequestMapping("find")
    public List<Iterm> searchIterm(String warehouse,String category){
        System.out.println(warehouse);
        System.out.println(category);
        List<Iterm> list=new ArrayList<>();
        if(StringUtils.isNotEmpty(warehouse)&&StringUtils.isNotEmpty(category)){
            list=itermRepository.findAllByWarehouseAndCategory(warehouse,category);
            System.out.println(1);
        }
        else if(StringUtils.isNotEmpty(warehouse)){
            list=itermRepository.findAllByWarehouse(warehouse);
            System.out.println(2);
        }
        else if(StringUtils.isNotEmpty(category)){
            list=itermRepository.findAllByCategory(category);
            System.out.println(3);
        }
        else {
            list=itermRepository.findAll();
            System.out.println(4);
        }
//        if(StringUtils.isEmpty(warehouse)){
//            List<Iterm> result=new ArrayList<>();
//            List<String> model=new ArrayList<>();
//            Map<String,Iterm> numMap = new HashMap<>();
//            for (Iterm iterm:
//                    list) {
//                if(numMap.containsKey(iterm.getModel())){
//                    int num=numMap.get(iterm.getModel()).getNum()+iterm.getNum();
//                    iterm.setNum(num);
//                    numMap.remove(iterm.getModel());
//                    numMap.put(iterm.getModel(),iterm);
//                }
//                else {
//                    numMap.put(iterm.getModel(),iterm);
//                }
//            }
//            for (Iterm iterm : numMap.values()) {
//                result.add(iterm);
//            }
//            return result;
//        }
        return list;
    }

    @RequestMapping("findByModel")
    public List<Iterm> findByModel(String model){
        List<Iterm> list=new ArrayList<>();
        if(StringUtils.isNotEmpty(model)){
            list=itermRepository.findAllByModel(model);
        }
        return list;
    }

    @RequestMapping("findRecord")
    public List<Details> findRecord(String model){
        System.out.println(model);

        List<Details> list=new ArrayList<>();

        if(StringUtils.isNotEmpty(model)){
            list=detailsRepository.findAllByModel(model);
            System.out.println(1111);
        }
        else {
            list=detailsRepository.findAll();
        }
        for (Details de:list
             ) {
            de.toString();
        }

        return list;
    }

    @ResponseBody
    @PostMapping(value = "edit",produces = "application/json;charset=UTF-8")
    public void edit(@RequestBody JSONObject data){
        Iterm iterm=new Iterm();
        Details details=new Details();
        JSONObject itermJson= data.getJSONObject("data");

        details.setWarehouse(itermJson.getString("warehouse"));
        details.setBrand(itermJson.getString("brand"));
        details.setCategory(itermJson.getString("category"));
        details.setModel(itermJson.getString("model"));
        details.setNum(Integer.valueOf(itermJson.getString("outNum")));
        details.setOperator("manager");
        details.setOperation("out");
        detailsRepository.save(details);

        iterm.setWarehouse(itermJson.getString("warehouse"));
        iterm.setBrand(itermJson.getString("brand"));
        iterm.setCategory(itermJson.getString("category"));
        iterm.setModel(itermJson.getString("model"));
        iterm.setNum(Integer.valueOf(itermJson.getString("num")));
        int num=Integer.valueOf(itermJson.getString("num"))-Integer.valueOf(itermJson.getString("outNum"));
        if(num==0){
            System.out.println(1111);
            Iterm itermUpdate=new Iterm();
            itermUpdate=itermRepository.findItermByWarehouseAndModelAndBrandAndCategory(iterm.getWarehouse(),iterm.getModel(),iterm.getBrand(),iterm.getCategory());
            itermRepository.delete(itermUpdate);
        }
        else {
            Iterm itermUpdate=new Iterm();
            itermUpdate=itermRepository.findItermByWarehouseAndModelAndBrandAndCategory(iterm.getWarehouse(),iterm.getModel(),iterm.getBrand(),iterm.getCategory());
            itermUpdate.setNum(num);
            itermRepository.save(itermUpdate);
        }
    }
}
