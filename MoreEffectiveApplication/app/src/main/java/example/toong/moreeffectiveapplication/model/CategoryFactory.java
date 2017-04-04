package example.toong.moreeffectiveapplication.model;

import java.util.ArrayList;
import java.util.List;

import static example.toong.moreeffectiveapplication.model.Category.BATTERY;
import static example.toong.moreeffectiveapplication.model.Category.HEALTH;

/**
 * Created by phanvanlinh on 28/02/2017.
 * phanvanlinh.94vn@gmail.com
 */

public class CategoryFactory {
    
    public static List<Category> buildDefaultCategory() {
        List<Category> mCategoryList = new ArrayList<>();
        return mCategoryList;
    }

    public static Category buildCategory(@Category.WeekDays int type){
        Category category = new Category();
        category.setType(type);
        switch (type){
            case BATTERY:
                category.setName("s");
                category.setIcon(1);
            case HEALTH:
                category.setName("s");
                category.setIcon(2);
        }

        return category;
    }
}
