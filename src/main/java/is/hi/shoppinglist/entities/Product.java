package is.hi.shoppinglist.entities;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private boolean isInShoppingList;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private Person person;

    public Product() {
    }

    public Product(String name, boolean isInShoppingList, Person person) {
        this.name = name;
        this.isInShoppingList = isInShoppingList;
        this.person = person;
    }

    public boolean isInShoppingList() {
        return isInShoppingList;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
