package com.gdtico.dto;

import com.gdtico.entity.Setmeal;
import com.gdtico.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
