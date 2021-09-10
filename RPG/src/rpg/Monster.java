package rpg;

import java.util.ArrayList;
import java.util.Random;

public class Monster extends Character {
    Random random = new Random();
    private ArrayList<Animal> animals = new ArrayList<Animal>();  // 動物清單
    private ArrayList<Demon> demons = new ArrayList<Demon>();  // 魔物清單
    private ArrayList<Item> dropItems = new ArrayList<Item>();  // 掉落物清單


    public void setAnimals() {
        Animal wolf = new Animal();
        Animal lion = new Animal();
        Animal boar = new Animal();
        Animal elephant = new Animal();
        wolf.wolf();
        animals.add(wolf);
        lion.lion();
        animals.add(lion);
        boar.boar();
        animals.add(boar);
        elephant.elephant();
        animals.add(elephant);
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }  // 取得動物清單

    public void setDemons() {
        Demon demonWolf = new Demon();
        Demon celestialHuang = new Demon();
        Demon mountainDemon = new Demon();
        Demon bahamut = new Demon();
        demonWolf.demonWolf();
        demons.add(demonWolf);
        celestialHuang.celestialHuang();
        demons.add(celestialHuang);
        mountainDemon.mountainDemon();
        demons.add(mountainDemon);
        bahamut.bahamut();
        demons.add(bahamut);
    }

    public ArrayList<Demon> getDemons() {
        return demons;
    }  // 取得魔物清單

    public ArrayList<Item> getDropItems() {
        return dropItems;
    }

    public Item getDropItem() {
        Item item = null;
        item = getDropItems().get(random.nextInt(getDropItems().size()));
        return item;
    }
}