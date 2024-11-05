package se.anna.main.fight;

public abstract class Entity {
    private final String role;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int takeDamage(int damage) {
        health -= damage;
        return health;
    }

    public void attack(Entity toPunch) {
        toPunch.takeDamage(damage);
    }

    public boolean isConscious() {
        return health > 0;
    }
}
