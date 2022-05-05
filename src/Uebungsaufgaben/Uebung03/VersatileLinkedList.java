package Uebungsaufgaben.Uebung03;

public class VersatileLinkedList extends LinkedStringList{

    public void add(Integer value) {
        String newValue = value.toString();
        add(newValue);
    }

    public void add(Boolean bool) {
        if (bool) {
            add("yes");
        } else {
            add("no");
        }
    }

    public void add(LinkedStringList liste) {
        for (int i = 0; i < liste.size(); i++) {
            add(liste.get(i));
        }
    }

    public void add(LinkedStringList liste, Integer start, Integer end) {
        for (int i = start; i < end; i++) {
            add(liste.get(i));
        }
    }

    public LinkedStringList reverse(LinkedStringList liste) {
        VersatileLinkedList list = new VersatileLinkedList();

        for(int i = size() - 1; i >= 0; i--) {
            list.add(get(i));
        }

        return list;
    }

    public boolean equals(VersatileLinkedList list) {
        if(this.size() != list.size()) {
            return false;
        } else
            for(int i = 0; i < list.size(); i++) {
                if(!list.get(i).equals(this.get(i))) {
                    return false;
                }
            }
        return true;
    }

}

