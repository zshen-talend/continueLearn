package optional;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class optionalTest {
    public static void whenCreateOfNullableOptional_thenOk() {
        String name = "John";
        Optional<String> opt = Optional.ofNullable(name);

        System.out.println("John:"+ opt.get());
    }

    public static void whenCreateOfOptional_thenOk() {
        String name = null;
        Optional<String> opt = Optional.of(name);

        System.out.println("John:"+ opt.get());
    }

//    public static void whenCheckIfPresent_thenOk() {
//        String name = "John";
//        Optional<String> opt = Optional.ofNullable(name);
//        System.out.println(opt.isPresent());
//
//        System.out.println(opt.get());
//    }
    public static void whenCheckIfPresent_thenOk() {
        String name = "John";
        Optional<String> opt = Optional.ofNullable(name);
        opt.ifPresent( u -> System.out.println(opt.get()));
    }

    public static void whenEmptyValue_thenReturnDefault() {
        String name = "John";
        System.out.println(Optional.ofNullable(name).orElse(createNewName()));
        System.out.println(Optional.ofNullable(name).orElseGet(() -> createNewName()));
        name = null;
        System.out.println(Optional.ofNullable(name).orElse(createNewName()));
        System.out.println(Optional.ofNullable(name).orElseGet( () -> createNewName()));

    }
    public static void whenEmptyValue_throwException() {
        String name = null;
        System.out.println(Optional.ofNullable(name).orElse(createNewName()));
        System.out.println(Optional.ofNullable(name).orElseGet(() -> createNewName()));
        Optional.ofNullable(name)
                .orElseThrow( () -> new IllegalArgumentException());

    }

    public static String createNewName(){
        System.out.println("create new name");
        return "new name";
    }

    public void whenMap_thenOk() {
        User user = new User("anna@gmail.com", "1234");
        String email = Optional.ofNullable(user)
                .map(u -> u.getEmail()).orElse("default@gmail.com");

        System.out.println(email);
    }

    public void whenFlatMap_thenOk() {
        User user = new User("anna@gmail.com", "1234");
        user.setPosition("Developer");
        String position = Optional.ofNullable(user)
                .flatMap(u -> u.getPosition()).orElse("default");

        System.out.println(position);
        user.setPosition("Quality Administrator");
         position = Optional.ofNullable(user)
                .map(u -> u.getPosition()).get().orElse("default");

        System.out.println(position);
    }

    public void whenFilter_thenOk() {
        User user = new User("anna@gmail.com", "1234");
        Optional<User> result = Optional.ofNullable(user)
                .filter(u -> u.getEmail() != null && u.getEmail().contains("@"));

        System.out.println(result.isPresent());
    }

    public void whenChaining_thenOk() {
        User user = new User("anna@gmail.com", "1234",new Address(new Country("the new code")));

        String result = Optional.ofNullable(user)
                .flatMap(u -> u.getAddress())
                .flatMap(a -> a.getCountry())
                .map(c -> c.getIsocode())
                .orElse("default");

        System.out.println(result);
        System.out.println(Optional.ofNullable(user).flatMap(User::getAddress).flatMap(Address::getCountry).map(Country::getIsocode).orElse("default"));
    }

    public void whenGetStream_thenOk() {
        User user = new User("john@gmail.com", "1234");
        List<String> emails = Optional.ofNullable(user).stream().filter(u -> u.getEmail() != null && u.getEmail().contains("@")).map( u -> u.getEmail()).collect(Collectors.toList());

        System.out.println(emails.size() == 1);
        System.out.println(emails.get(0));
    }

    public void whenEmptyStream_thenReturnDefaultOptional() {
        List<User> users = new ArrayList<>();
        User user = users.stream().findFirst().orElse(new User("default", "1234"));

        System.out.println(user.getEmail());
    }

    public static void main(String[] args) {
        new optionalTest().whenEmptyStream_thenReturnDefaultOptional();
    }

    @Data
    public class User {
        private String position;
        private String email;
        private String name;
        private Optional<Address> address;

        public Optional<String> getPosition() {
            return Optional.ofNullable(position);
        }
        public void setPosition(String position) {
            this.position=position;
        }

        public User(String email,String name){
            this.email=email;
            this.name=name;
        }
        public User(String email,String name,Address address){
            this.email=email;
            this.name=name;
            this.address=Optional.ofNullable(address);
        }



        //...
    }
    @Data
    class Address{
        public Address(Country country){
            this.country =Optional.ofNullable( country);
        }
        Optional<Country> country;
    }

    @Data
    class Country{
        public String isocode;
        
        public Country(String theIsocode){
            this.isocode=theIsocode;
        }
    }
}
