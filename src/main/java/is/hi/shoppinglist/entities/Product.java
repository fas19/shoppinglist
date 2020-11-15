package is.hi.shoppinglist.entities;

import javax.persistence.*;

@Entity(name="Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private boolean isInShoppingList;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Product() {
    }

    public Product(String name, boolean isInShoppingList, User user) {
        this.name = name;
        this.isInShoppingList = isInShoppingList;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
