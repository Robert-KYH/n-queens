
class NQueens {

  int längd;
  boolean[][] bräde;

  NQueens(int n) {  längd = n;  bräde = new boolean[n][n];  }


  void lös() {
    lösRekursiv(0, 0, 0, 0);

    for (int r = 0; r < längd; ++r) {
      for (int k = 0; k < längd; ++k)
        System.out.print(bräde[r][k] ? " \u2655" : " \u25a2");
      System.out.println();
    }
  }


  boolean lösRekursiv(int rad, int vänster, int ovan, int höger) {

    if (rad == längd)  return true;

    int ogiltiga = vänster|ovan|höger;

    for (int kol = 0; kol < längd; ++kol) {
      int kolMask = 1<<kol;
      if ((kolMask&ogiltiga) != 0)  continue;

      bräde[rad][kol] = true;
      if (lösRekursiv(rad+1, (vänster|kolMask)<<1, ovan|kolMask, (höger|kolMask)>>1))  return true;
      bräde[rad][kol] = false;
    }

    return false;
  }


  public static void main(String[] args) {  new NQueens(8).lös();  }
}
