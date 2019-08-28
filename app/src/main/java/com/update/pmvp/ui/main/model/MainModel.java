package com.update.pmvp.ui.main.model;

import com.update.pmvp.ui.main.contract.MainContract;

/**
 * @author : liupu
 * date   : 2019/4/19
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class MainModel implements MainContract.Model {

    @Override
    public String loadData() {
        return "Update";
    }

}
