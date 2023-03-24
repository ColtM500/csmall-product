package cn.chen.csmall.product.service.impl;

import cn.chen.csmall.product.ex.ServiceException;
import cn.chen.csmall.product.mapper.AttributeTemplateMapper;
import cn.chen.csmall.product.pojo.dto.AttributeTemplateAddNewDTO;
import cn.chen.csmall.product.pojo.entity.AttributeTemplate;
import cn.chen.csmall.product.service.IAttributeTemplateService;
import cn.chen.csmall.product.web.ServiceCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttributeTemplateServiceImpl implements IAttributeTemplateService {
    @Autowired
    private AttributeTemplateMapper mapper;

    @Override
    public void addNew(AttributeTemplateAddNewDTO attributeTemplateAddNewDTO) {
        // 从参数对象中获取属性模板ID和名称
        Long id = attributeTemplateAddNewDTO.getId();
        String name = attributeTemplateAddNewDTO.getName();
        // 调用AttributeTemplateMapper的int countByName(String name)根据名称执行统计
        int countByName = mapper.countByNameAndNotId(id,name);
        // 判断统计结果是否大于0
        if (countByName>0){
            // 是：抛出异常throw new RuntimeException()
            String message = "添加属性模板失败, 属性模板名称已被占用!";
            throw new ServiceException(2222, message);
        }

        // 创建AttributeTemplate对象
        AttributeTemplate attributeTemplate = new AttributeTemplate();
        // 调用BeanUtils.copyProperties()将参数对象的属性值复制到AttributeTemplate对象中
        BeanUtils.copyProperties(attributeTemplateAddNewDTO, attributeTemplate);
        // 调用AttributeTemplateMapper的int insert(AttributeTemplate AttributeTemplate)方法将相册数据插入到数据库
        mapper.insert(attributeTemplate);
    }
}
