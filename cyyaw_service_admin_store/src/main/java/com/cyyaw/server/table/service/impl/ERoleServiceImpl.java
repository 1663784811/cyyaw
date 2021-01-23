package com.cyyaw.server.table.service.impl;

import com.cyyaw.common.res.BaseResult;
import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.table.dao.ERoleDao;
import com.cyyaw.server.table.entity.EPower;
import com.cyyaw.server.table.entity.ERole;
import com.cyyaw.server.table.service.ERoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
@Slf4j
public class ERoleServiceImpl extends BaseService<ERole, Integer> implements ERoleService {

    @Autowired
    private ERoleDao eRoleDao;

    @Override
    public BaseDao getBaseDao() {
        return eRoleDao;
    }

    @Override
    public BaseResult findRoleList(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<ERole> all = eRoleDao.findAll(pageable);
        List<ERole> content = all.getContent();
        long total = all.getTotalElements();
        return BaseResult.ok(content, new BaseResult.Result(page, size, total));
    }

    @Override
    public ERole save(ERole eRole) {
        String tid = eRole.getTid();
        String oldpid = null;
        String oldTreecode = null;
        if(null == eRole.getCreatetime()){
            eRole.setCreatetime(new Date());
        }
        if(null == tid || tid.equals("")){
            eRole.setTid(StringUtilWHY.getUUID());
        }else{
            ERole e = eRoleDao.findByTid(tid);
            oldpid  = e.getPid();
            oldTreecode = e.getTreecode();
        }
        String pid = eRole.getPid();
        if(null ==pid) pid="";
        if(!pid.equals(oldpid)){
            String pTreeCode = "";
            if(null != pid && !pid.equals("")){
                ERole pe = eRoleDao.findByTid(pid);
                if(null != pe){
                    pTreeCode = pe.getTreecode();
                }
            }
            String s = eRoleDao.maxPid(pid);
            int trint = 1;
            if(null != s && !"".equals(s)){
                trint = Integer.parseInt(s)+1;
            }
            String tr = StringUtilWHY.createStrLength(trint + "", 3, "0");
            eRole.setTreecode(pTreeCode+tr);
        }
        ERole ep = eRoleDao.save(eRole);
        String newtreecode = ep.getTreecode();
        if(null != oldTreecode && !oldTreecode.equals(newtreecode)){
            updateNextNode(oldTreecode,newtreecode);
        }
        return ep;
    }

    private void updateNextNode(String oldPtreecode, String nowPtreecode){
        List<ERole> nextNode = eRoleDao.findNextNode(oldPtreecode.length(), oldPtreecode);
        if(null != nextNode && nextNode.size()>0){
            for(int i=0;i<nextNode.size();i++){
                ERole eRole = nextNode.get(i);
                String treecode = eRole.getTreecode();
                eRole.setTreecode(treecode.replace(oldPtreecode,nowPtreecode));
                eRoleDao.save(eRole);
            }
        }
    }
}

