package cn.chen.csmall.product.service.impl;

import cn.chen.csmall.product.ex.ServiceException;
import cn.chen.csmall.product.mapper.BrandMapper;
import cn.chen.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.chen.csmall.product.pojo.dto.BrandUpdateNewDTO;
import cn.chen.csmall.product.pojo.entity.Album;
import cn.chen.csmall.product.pojo.entity.Brand;
import cn.chen.csmall.product.pojo.vo.BrandListItemVO;
import cn.chen.csmall.product.pojo.vo.BrandStandardVO;
import cn.chen.csmall.product.repository.IBrandCacheRepository;
import cn.chen.csmall.product.service.IBrandService;
import cn.chen.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BrandServiceImpl implements IBrandService {
    @Autowired
    private BrandMapper mapper;
    @Autowired
    private IBrandCacheRepository brandCacheRepository;

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
            throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
        }
        // 创建Brand对象
        Brand brand = new Brand();
        // 调用BeanUtils.copyProperties()将参数对象的属性值复制到Brand对象中
        BeanUtils.copyProperties(brandAddNewDTO, brand);
        // 调用BrandMapper的int insert(Brand brand)方法将品牌数据插入到数据库
        mapper.insert(brand);
    }

    @Override
    public List<BrandListItemVO> list() {
        log.debug("开始处理【查询品牌列表】的业务，无参数");
//        List<BrandListItemVO> list = mapper.list();
        List<BrandListItemVO> list = brandCacheRepository.list();
        return list;
    }

    @Override
    public BrandStandardVO getStandardById(Long id) {
        BrandStandardVO queryResult = mapper.getStandardById(id);
        if (queryResult == null) {
            String message = "获取品牌详情失败，尝试访问的数据不存在！";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        return queryResult;
    }

    @Override
    public void delete(Long id) {
        BrandStandardVO queryResult = mapper.getStandardById(id);
        if (queryResult == null) {
            String message = "删除品牌失败，尝试访问的数据不存在！";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        mapper.deleteById(id);
    }

    @Override
    public void updateInfoById(Long id, BrandUpdateNewDTO brandUpdateNewDTO) {
        BrandStandardVO queryResult = mapper.getStandardById(id);
        if (queryResult == null) {
            String message = "修改品牌详情失败，尝试访问的数据不存在！";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        String name = brandUpdateNewDTO.getName();
        int count = mapper.countByNameAndNotId(id, name);
        if (count > 0) {
            String message = "修改品牌详情失败，品牌名称已经被占用！";
            throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
        }

        Brand brand = new Brand();
        BeanUtils.copyProperties(brandUpdateNewDTO, brand);
        brand.setId(id);
        mapper.update(brand);
    }

    @Override
    public void rebuildCache() {
        log.debug("开始处理【重建品牌数据缓存】的业务，无参数");
        brandCacheRepository.deleteList();
        List<BrandListItemVO> brandList = mapper.list();
        brandCacheRepository.save(brandList);
    }
}
