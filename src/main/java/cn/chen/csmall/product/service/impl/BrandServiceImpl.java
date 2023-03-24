package cn.chen.csmall.product.service.impl;

import cn.chen.csmall.product.ex.ServiceException;
import cn.chen.csmall.product.mapper.BrandMapper;
import cn.chen.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.chen.csmall.product.pojo.entity.Album;
import cn.chen.csmall.product.pojo.entity.Brand;
import cn.chen.csmall.product.service.IBrandService;
import cn.chen.csmall.product.web.ServiceCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements IBrandService {
    @Autowired
    private BrandMapper mapper;

    @Override
    public void addNew(BrandAddNewDTO brandAddNewDTO) {
        // 从参数对象中获取品牌ID和名称
        Long id = brandAddNewDTO.getId();
        String name = brandAddNewDTO.getName();
        // 调用BrandMapper的int countByName(String name)根据名称执行统计
        int count = mapper.countByNameAndNotId(id,name);
        // 判断统计结果是否大于0
        if (count>0){
            // 是：抛出异常throw new RuntimeException()
            String message = "添加品牌名称失败, 名称已被占用!";
            throw new ServiceException(22222, message);
        }
        // 创建Brand对象
        Brand brand = new Brand();
        // 调用BeanUtils.copyProperties()将参数对象的属性值复制到Brand对象中
        BeanUtils.copyProperties(brandAddNewDTO, brand);
        // 调用BrandMapper的int insert(Brand brand)方法将品牌数据插入到数据库
        mapper.insert(brand);
    }
}
