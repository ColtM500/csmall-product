package cn.chen.csmall.product.service.impl;

import cn.chen.csmall.product.ex.ServiceException;
import cn.chen.csmall.product.mapper.AttributeTemplateMapper;
import cn.chen.csmall.product.pojo.dto.AttributeTemplateAddNewDTO;
import cn.chen.csmall.product.pojo.dto.AttributeTemplateUpdateNewDTO;
import cn.chen.csmall.product.pojo.entity.AttributeTemplate;
import cn.chen.csmall.product.pojo.vo.AttributeTemplateListItemVO;
import cn.chen.csmall.product.pojo.vo.AttributeTemplateStandardVO;
import cn.chen.csmall.product.service.IAttributeTemplateService;
import cn.chen.csmall.product.web.ServiceCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
            throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
        }

        // 创建AttributeTemplate对象
        AttributeTemplate attributeTemplate = new AttributeTemplate();
        // 调用BeanUtils.copyProperties()将参数对象的属性值复制到AttributeTemplate对象中
        BeanUtils.copyProperties(attributeTemplateAddNewDTO, attributeTemplate);
        // 调用AttributeTemplateMapper的int insert(AttributeTemplate AttributeTemplate)方法将相册数据插入到数据库
        mapper.insert(attributeTemplate);
    }

    @Override
    public List<AttributeTemplateListItemVO> list() {
        List<AttributeTemplateListItemVO> list = mapper.list();
        return list;
    }

    @Override
    public AttributeTemplateStandardVO getStandardById(Long id) {
        AttributeTemplateStandardVO queryResult = mapper.getStandardById(id);
        if (queryResult == null){
            String message = "获取属性模板详情失败, 尝试访问的数据不在!";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }
        return queryResult;
    }

    @Override
    public void delete(Long id) {
        AttributeTemplateStandardVO queryResult = mapper.getStandardById(id);
        if (queryResult == null){
            String message = "删除相册失败, 尝试访问的数据不存在!";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }
        mapper.deleteById(id);
    }

    @Override
    public void updateInfoById(Long id, AttributeTemplateUpdateNewDTO attributeTemplateUpdateNewDTO) {
        AttributeTemplateStandardVO queryResult = mapper.getStandardById(id);
        if (queryResult == null){
            String message = "删除相册失败, 尝试访问的数据不存在!";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        String name = attributeTemplateUpdateNewDTO.getName();
        int count = mapper.countByNameAndNotId(id, name);
        if (count>0){
            String message = "获取相册详情, 尝试访问的数据不在!";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        AttributeTemplate attributeTemplate = new AttributeTemplate();
        BeanUtils.copyProperties(attributeTemplateUpdateNewDTO, attributeTemplate);
        attributeTemplate.setId(id);
        mapper.update(attributeTemplate);
    }
}
