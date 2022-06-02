package com.company;

 class PrintingProccess implements Runnable {
    Thread print;
    static int ID =0;
    int quantity;
    Fabric f;
    PrintingMachine m;
    Entry e;

     PrintingProccess(PrintingMachine printingMachine,Entry entry,int quantity,Fabric fabric) {
            printingMachine.setReady(false);
             print = new Thread(this, "myThread");
             ID++;
             this.quantity = quantity;
             this.m = printingMachine;
             this.e = entry;
             this.f = fabric;
             System.out.println("TASK ID:" + this.ID + " Attempting to print on " + printingMachine.toString());
             print.start();
             printingMachine.setReady(true);
             if(this.m.isJobSuccess()){
                 printingMachine.setJobSuccess(true);
             }
         }

    @Override
    public void run() {
        if (m.isReady()) {
            boolean okay = true;
            try {

                boolean again = true;
                int jobSlots = m.getSlots();
                if (quantity < m.getSlots()) {
                    jobSlots = quantity;
                    again = false;
                }

                this.m.setReady(false);
                int step = 0;
                int iterations = quantity/m.getSlots();
                if (iterations<1)
                    iterations = 1;
                step = 0;
                int j;
                for (int circle = 0; circle <iterations; circle++) {
                    step = 0;
                    for (int i = 0; i < e.getEntryPageNumber() / m.getPrintPages_perMinute(); i++) {
                        m.print(e,quantity, step, step += m.getPrintPages_perMinute());
                        /*
                        System.out.print(" on Slots [");
                        for (j = 0; j < jobSlots - 1; j++)
                            System.out.print(j + 1 + ", ");
                        System.out.println(j + 1 + "]");

                         */
                       // if (m.getPrintPages_perMinute() <= 50)
                          // Thread.sleep(10000 - m.getPrintPages_perMinute() * 90);
                        Thread.sleep(1000);
                    }
                    if (e.getEntryPageNumber() % m.getPrintPages_perMinute() != 0) {
                        m.print(e,quantity, step, e.getEntryPageNumber());
                        /*
                        System.out.print(" on Slots [");
                        for (j = 0; j < jobSlots - 1; j++)
                            System.out.print(j + 1 + ", ");
                        System.out.println(j + 1 + "]");

                         */
                    }
                }
                    if (again && quantity % m.getSlots() != 0) {
                        jobSlots = quantity % m.getSlots();;
                        step = 0;

                        for (int i = 0; i < e.getEntryPageNumber() / m.getPrintPages_perMinute(); i++) {
                            m.print(e,quantity, step, step += m.getPrintPages_perMinute());
                            /*
                            System.out.print(" on Slots [");
                            for (j = 0; j < jobSlots - 1; j++)
                                System.out.print(j + 1 + ", ");
                            System.out.println(j + 1 + "]");

                             */
                           // if (m.getPrintPages_perMinute() <= 50)
                               // Thread.sleep(10000 - m.getPrintPages_perMinute() * 90);
                            Thread.sleep(1000);
                        }
                        if (e.getEntryPageNumber() % m.getPrintPages_perMinute() != 0) {
                            m.print(e,quantity, step, e.getEntryPageNumber());
                            /*
                            System.out.print(" on Slots [");
                            for (j = 0; j < jobSlots - 1; j++)
                                System.out.print(j + 1 + ", ");
                            System.out.println(j + 1 + "]");

                             */
                        }
                    }
                    m.setCharged_withPages(m.getCharged_withPages()-(quantity*e.getEntryPageNumber()));

            } catch (InterruptedException e) {
                okay = false;
                System.err.println("Interrupted");
            } catch (MachineNotEnoughPaperException e) {
                okay = false;
                System.err.println(e);
            }

            System.out.println("Machine: " + m.getName() + " is READY");
            this.m.setReady(true);
            this.m.setJobSuccess(true);
            if(okay) {
                if (f.checkReadyEntriesIndex(e) == -1) {
                    f.addToReadyEntries(e);
                    f.addToReadyEntriesQuantity(quantity);
                } else {
                    f.addQuantityToExistingEntry(f.checkReadyEntriesIndex(e), quantity);
                }
            }
        }
        else{
            System.err.println("Machine: " + m.getName() + " currently NOT READY");
        }
    }
}
