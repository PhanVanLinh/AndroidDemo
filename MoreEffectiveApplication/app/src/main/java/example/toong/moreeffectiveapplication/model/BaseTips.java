package example.toong.moreeffectiveapplication.model;

import java.util.List;

/**
 * Created by phanvanlinh on 28/02/2017.
 * phanvanlinh.94vn@gmail.com
 */

public abstract class BaseTips {
    private int id;
    private String title;
    private String description;
    protected List<Category> mCategoryList;

    public void addCategory(Category category){
        mCategoryList.add(category);
    }
}
