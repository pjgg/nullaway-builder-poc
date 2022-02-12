package org.bytesandmonkeys.nullaway;

import org.apache.commons.lang3.StringUtils;

public class Monkey {
    private String name;
    private String breed;
    private int age;

    private Monkey (Builder builder) {
        this.age = builder.age;
        this.breed = builder.breed;
        this.name = builder.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static class Builder {
        private String name = StringUtils.EMPTY;
        private String breed = StringUtils.EMPTY;
        private int age;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Builder withAge(int age) {
            this.age  = age;
            return this;
        }

        public Builder fromPrototype(Monkey monkey) {
            this.age = monkey.getAge();
            this.breed = monkey.getBreed() == null ? StringUtils.EMPTY : monkey.getBreed();
            this.name = monkey.getName() == null ? StringUtils.EMPTY : monkey.getName();
            return this;
        }

        public Monkey build() {
            return new Monkey(this);
        }
    }
}
