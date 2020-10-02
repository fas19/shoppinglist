package is.hi.shoppinglist.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private boolean isInShoppingList;

    public Product() {
    }

    public Product(String name, boolean isInShoppingList) {
        this.name = name;
        this.isInShoppingList = isInShoppingList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsInShoppingList() {
        return isInShoppingList;
    }

    public void setInShoppingList(boolean inShoppingList) {
        this.isInShoppingList = inShoppingList;
    }

}
