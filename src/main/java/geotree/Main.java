package geotree;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Person irina = new Person("Ирина","Иванова",1970 ,Gender.female);
        Person vasya = new Person("Вася","Иванов",1990 ,Gender.male);
        Person masha = new Person("Маша","Сидорова",1995 ,Gender.female);
        Person jane = new Person("Женя","Иванова",2015 ,Gender.female);
        Person ivan = new Person("Ваня","Иванов",2018 ,Gender.male);
        Person sasha = new Person("Саша","Сидоров",1990 ,Gender.male);
        Person dima = new Person("Дима","Сидоров",2020 ,Gender.male);
        Person lena = new Person("Лена","Григорьева",1949 ,Gender.female);
        Person lena1 = new Person("Лена","Григорьева",1949 ,Gender.female);
        System.out.println(lena.equals(lena1));
//        GeoTree gt = new GeoTree();
//        gt.append(irina, vasya);
//        gt.append(irina, masha);
//        gt.append(vasya, jane);
//        gt.append(vasya, ivan);
//        gt.append(masha, dima);
//        gt.append(sasha, dima);
//        gt.append(lena,irina);
//        Research rs1 = new Research(gt);
//
//        rs1.spend(vasya, Relationship.parent);
//        rs1.createFile();
//        rs1.spend(masha);
//        rs1.createFile();
//        rs1.spend(irina,true);
//        rs1.createFile();
    }

}
