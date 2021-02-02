package com.cyyaw.server.table.service.impl;

import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.server.dao.MenuDao;
import com.cyyaw.server.table.service.MenuService;
import com.cyyaw.server.table.entity.EPower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<EPower> getMenuList() {
        return menuDao.findAll();
    }

    @Override
    public List<EPower> getAdminMenu(String admintid) {
        return menuDao.getAdminMenu(admintid);
    }


    @Override
    public EPower save(EPower ePower) {
        String tid = ePower.getTid();
        String oldpid = null;
        String oldTreecode = null;
        if(null == tid || tid.equals("")){
            ePower.setTid(StringUtilWHY.getUUID());
        }else{
            EPower e = menuDao.findByTid(tid);
            oldpid  = e.getPid();
            oldTreecode = e.getTreecode();
        }
        String pid = ePower.getPid();
        if(null ==pid) pid="";
        //===================  移动树节点
        if(!pid.equals(oldpid)){
            String pTreeCode = "";
            if(null != pid && !pid.equals("")){
                EPower pe = menuDao.findByTid(pid);
                if(null != pe){
                    pTreeCode = pe.getTreecode();
                }
            }
            String s = menuDao.maxPid(pid);
            int trint = 1;
            if(null != s && !"".equals(s)){
                trint = Integer.parseInt(s)+1;
            }
            String tr = StringUtilWHY.createStrLength(trint + "", 3, "0");
            ePower.setTreecode(pTreeCode+tr);
        }
        EPower ep = menuDao.save(ePower);
        String newtreecode = ep.getTreecode();
        // 更新子节点
        if(null != oldTreecode && !oldTreecode.equals(newtreecode)){
            updateNextNode(oldTreecode,newtreecode);
        }
        return ep;
    }

    @Override
    public void delMenu(EPower ePower) {
        menuDao.delete(menuDao.findByid(ePower.getId()));
    }

    private void updateNextNode(String oldPtreecode, String nowPtreecode){
        List<EPower> nextNode = menuDao.findNextNode(oldPtreecode.length(), oldPtreecode);
        if(null != nextNode && nextNode.size()>0){
            for(int i=0;i<nextNode.size();i++){
                EPower ePower = nextNode.get(i);
                String treecode = ePower.getTreecode();
                ePower.setTreecode(treecode.replace(oldPtreecode,nowPtreecode));
                menuDao.save(ePower);
            }
        }
    }

}
