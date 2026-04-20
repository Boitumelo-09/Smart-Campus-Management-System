package simulatedDB;

import models.Staff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegisteredStaff {



    public static List<Staff> getStaffList() {
        List<Staff> staffList = new ArrayList<>();

        staffList.add(new Staff("Manager", "Mkhondo", "Boitumelo", 1));
        staffList.add(new Staff("Developer", "Nkosi", "Thabo", 2));
        staffList.add(new Staff("Developer", "Mokoena", "Lerato", 3));
        staffList.add(new Staff("HR", "Dlamini", "Siphesihle", 4));
        staffList.add(new Staff("Security", "Zulu", "Sibusiso", 5));
        staffList.add(new Staff("Cleaner", "Mabaso", "Nomsa", 6));
        staffList.add(new Staff("Developer", "Khumalo", "Ayanda", 7));
        staffList.add(new Staff("Manager", "Ndlovu", "Bongani", 8));
        staffList.add(new Staff("Intern", "Maseko", "Zanele", 9));
        staffList.add(new Staff("HR", "Cele", "Themba", 10));
        staffList.add(new Staff("Security", "Mthembu", "Phumlani", 11));
        staffList.add(new Staff("Developer", "Ngcobo", "Nokuthula", 12));
        staffList.add(new Staff("Developer", "Sithole", "Andile", 13));
        staffList.add(new Staff("Cleaner", "Mahlangu", "Pretty", 14));
        staffList.add(new Staff("Manager", "Madonsela", "Tshepo", 15));
        staffList.add(new Staff("Intern", "Baloyi", "Rhandzu", 16));
        staffList.add(new Staff("HR", "Motsepe", "Kagiso", 17));
        staffList.add(new Staff("Developer", "Phiri", "Chipo", 18));
        staffList.add(new Staff("Security", "Mabena", "Collins", 19));
        staffList.add(new Staff("Cleaner", "Sekhukhune", "Mmapula", 20));
        staffList.add(new Staff("Developer", "Letsoalo", "Katlego", 21));
        staffList.add(new Staff("Manager", "Ramaphosa", "Neo", 22));
        staffList.add(new Staff("Intern", "Mogale", "Tshegofatso", 23));
        staffList.add(new Staff("HR", "Molefe", "Palesa", 24));
        staffList.add(new Staff("Developer", "Mokgadi", "Thabang", 25));
        staffList.add(new Staff("Security", "Shabalala", "Sfiso", 26));
        staffList.add(new Staff("Cleaner", "Maree", "Annelize", 27));
        staffList.add(new Staff("Developer", "Botha", "Johan", 28));
        staffList.add(new Staff("Manager", "Naidoo", "Priya", 29));
        staffList.add(new Staff("Intern", "Pillay", "Kavish", 30));

        return staffList;


}}
