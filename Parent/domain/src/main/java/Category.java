import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Category {
    private String categoryName;


    public Category(String categoryName) {

        this.categoryName = categoryName;
    }
}
