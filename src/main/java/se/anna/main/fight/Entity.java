package se.anna.main.fight;

public abstract class Entity {
    private String role;
    private int health;
    private int damage;

    public Entity(String role, int health, int damage) {
        this.role = role;
        this.health = health;
        this.damage = damage;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getHealth() {
        return health;
    }

    public int setHealth(int damage) {
        health -= damage;
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void attack(Entity toPunch) {
        toPunch.setHealth(damage);
    }

    public boolean isConscious() {
        return health > 0;
    }
}
