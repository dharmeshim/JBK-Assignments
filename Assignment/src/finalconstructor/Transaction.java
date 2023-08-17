package finalconstructor;

class Transaction {
    private boolean isTransactionDone;

    public Transaction(boolean isTransactionDone) {
        this.isTransactionDone = isTransactionDone;
    }
    
    public boolean transactionStatus() {
    	return isTransactionDone;
    }

    
    public boolean makeTransaction() {
    	
    	isTransactionDone=true;
        return isTransactionDone;
    }
}