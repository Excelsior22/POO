package Poli_eso_2;

class C1 {
    public void a() {
        System.out.println("C1.a()");
    }
    
}

class C2 extends C1 {
    @Override
    public void a() {
        System.out.println("C2.a()");
    }
}

class A {
    public C1 getC() {
        return new C2();
    }
    
    public void p(C1 c) {
        System.out.println("A.p(C1)");
        c.a();
    }
    
    public void p(C2 c) {
        System.out.println("A.p(C2)");
        c.a();
    }
}