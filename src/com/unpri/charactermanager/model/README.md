# Character Manager — TP3 (Java Visual SIH-6406)

## 1. Deskripsi Project

**Character Manager** merupakan project Java yang dibuat untuk memenuhi tugas **TP3 — Character Manager Sprint #1** pada mata kuliah **Java Visual (SIH-6406)**. Project ini merupakan pengembangan dasar dari class model menggunakan konsep **Object-Oriented Programming (OOP)**.

Pada tahap ini, program berfokus pada pembuatan class `Character` dan `CharacterType` sebagai fondasi dari aplikasi Character Manager. Program memiliki beberapa atribut seperti id, nama, level, tipe karakter, hit points, attack, dan mana. Selain itu, program juga memiliki fitur level up dan pengecekan status karakter menggunakan method `isAlive()`.

Project ini dibuat dengan struktur package yang terorganisasi agar kode lebih mudah dibaca, dikembangkan, dan dipelihara pada tahap pengembangan berikutnya.

---

## 2. Tujuan Project

Tujuan dari pembuatan project ini adalah:

1. Menerapkan konsep dasar pemrograman Java menggunakan class dan object.
2. Menerapkan konsep **encapsulation** dengan menggunakan atribut `private`.
3. Menggunakan `enum` untuk menentukan jenis karakter.
4. Membuat constructor untuk membentuk object `Character`.
5. Menggunakan getter dan setter untuk mengakses serta mengubah data object.
6. Menerapkan method `levelUp()` untuk meningkatkan level karakter.
7. Menambahkan atribut `mana` sebagai pengembangan fitur.
8. Menerapkan validasi pada nilai mana agar tidak boleh negatif.
9. Membuat method `isAlive()` untuk mengetahui kondisi karakter.
10. Menampilkan informasi object menggunakan method `toString()`.

---

## 3. Fitur Program

Program Character Manager memiliki beberapa fitur utama, yaitu:

### 3.1 Character Type

Program menggunakan `CharacterType` dalam bentuk `enum` yang memiliki empat jenis karakter:

```text
WARRIOR
MAGE
ARCHER
ASSASSIN
```

Penggunaan enum membuat tipe karakter lebih terstruktur dan mengurangi risiko kesalahan penulisan seperti yang dapat terjadi apabila tipe karakter disimpan sebagai `String`.

### 3.2 Character Object

Class `Character` digunakan sebagai model utama untuk menyimpan informasi setiap karakter. Beberapa data yang dimiliki antara lain:

- ID karakter
- Nama karakter
- Level
- Tipe karakter
- Hit Points
- Attack
- Mana

### 3.3 Constructor

Class `Character` memiliki dua constructor yang dapat digunakan untuk membuat object dengan kebutuhan yang berbeda.

Constructor pertama digunakan ketika data level awal ingin ditentukan secara langsung, sedangkan constructor kedua digunakan untuk membuat karakter dengan level awal yang lebih sederhana.

### 3.4 Level Up

Program memiliki method `levelUp()` yang digunakan untuk meningkatkan level karakter. Ketika level bertambah, nilai hit points dan attack juga diperbarui secara otomatis.

### 3.5 Mana

Pada TP3 ditambahkan atribut `mana` dengan tipe data `int`.

Nilai mana dapat diubah menggunakan:

```java
setMana()
```

Program juga memberikan validasi sehingga nilai mana tidak boleh negatif. Jika nilai negatif diberikan, program akan menghasilkan `IllegalArgumentException`.

### 3.6 Is Alive

Program memiliki method:

```java
isAlive()
```

Method tersebut digunakan untuk memeriksa apakah karakter masih hidup berdasarkan nilai `hitPoints`.

Jika:

```text
hitPoints > 0
```

maka hasilnya:

```text
true
```

Sedangkan jika hit points bernilai 0 atau kurang, hasilnya adalah:

```text
false
```

---

## 4. Konsep OOP yang Digunakan

Project ini menerapkan beberapa konsep dasar Object-Oriented Programming.

### Encapsulation

Atribut dalam class `Character` dibuat menggunakan akses `private`. Data tersebut tidak dapat diakses secara langsung dari class lain dan harus melalui getter atau setter.

Contohnya:

```java
private int mana;
```

Kemudian untuk mengaksesnya digunakan:

```java
getMana()
```

dan untuk mengubahnya digunakan:

```java
setMana()
```

Dengan cara ini, data dapat diberikan validasi sebelum diubah.

### Enum

`CharacterType` menggunakan enum untuk membatasi pilihan tipe karakter hanya pada nilai yang telah ditentukan.

### Constructor

Constructor digunakan untuk menginisialisasi object `Character` ketika object dibuat.

### Method

Beberapa method digunakan untuk memberikan perilaku kepada object, seperti:

```text
levelUp()
isAlive()
getMana()
setMana()
toString()
```

Dengan demikian, class `Character` tidak hanya menyimpan data, tetapi juga memiliki perilaku yang berkaitan dengan data tersebut.

---

## 5. Struktur Folder Project

Struktur project dibuat menggunakan package `com.unpri.charactermanager` dan `com.unpri.charactermanager.model`.

```text
CharacterManager/
├── src/
│   └── com/
│       └── unpri/
│           └── charactermanager/
│               ├── Main.java
│               │
│               └── model/
│                   ├── Character.java
│                   └── CharacterType.java
│
├── output.png
└── README.md
```

Keterangan:

- `Main.java` digunakan sebagai class utama untuk menjalankan program dan melakukan demonstrasi fitur.
- `Character.java` merupakan model yang menyimpan data dan perilaku karakter.
- `CharacterType.java` merupakan enum yang menentukan jenis karakter.
- `output.png` merupakan screenshot hasil program ketika dijalankan.
- `README.md` berisi dokumentasi project.

---

## 6. Cara Menjalankan Program

Program dapat dijalankan menggunakan Java Development Kit (JDK).

Pastikan Java sudah terpasang pada komputer. Setelah project dibuka di Visual Studio Code, program dapat dijalankan melalui `Main.java`.

Program akan menampilkan informasi beberapa karakter, proses level up, serta demonstrasi fitur mana dan `isAlive()`.

Contoh perintah melalui terminal apabila diperlukan:

```bash
javac -d out src/com/unpri/charactermanager/model/CharacterType.java src/com/unpri/charactermanager/model/Character.java src/com/unpri/charactermanager/Main.java
```

Kemudian jalankan:

```bash
java -cp out com.unpri.charactermanager.Main
```

---

## 7. Contoh Output Program

Berikut merupakan contoh hasil ketika program berhasil dijalankan:

```text
=== CHARACTER MANAGER - TP3 ===

Character{id=1, name='Arthur', level=10, type=WARRIOR, hitPoints=200, attack=60, mana=0}
Character{id=2, name='Merlin', level=15, type=MAGE, hitPoints=250, attack=85, mana=0}
Character{id=3, name='Robin', level=1, type=ARCHER, hitPoints=110, attack=15, mana=0}

=== DEMO LEVEL UP ===

Sebelum level up:
Character{id=1, name='Arthur', level=10, type=WARRIOR, hitPoints=200, attack=60, mana=0}

Setelah level up:
Character{id=1, name='Arthur', level=11, type=WARRIOR, hitPoints=210, attack=65, mana=0}

=== DEMO MANA & IS ALIVE ===

Character{id=4, name='Necro', level=5, type=MAGE, hitPoints=150, attack=35, mana=100}
Mana: 100
Is alive: true
```

---

## 8. Screenshot Output Terminal

Screenshot berikut menunjukkan hasil eksekusi program pada terminal, termasuk demonstrasi fitur `mana` dan `isAlive()`.

![Output Terminal](output.png)

---

## 9. Validasi Mana

Atribut `mana` memiliki validasi agar nilainya tidak boleh negatif.

Contoh penggunaan:

```java
character.setMana(100);
```

Kode tersebut akan memberikan nilai mana sebesar 100.

Namun apabila diberikan nilai negatif:

```java
character.setMana(-50);
```

program akan memberikan:

```text
IllegalArgumentException
```

Validasi tersebut digunakan agar data karakter tetap memiliki nilai yang masuk akal.

---

## 10. Pengembangan Selanjutnya

Project Character Manager pada TP3 merupakan fondasi awal untuk pengembangan aplikasi pada sprint berikutnya. Struktur class dan package yang telah dibuat dapat dikembangkan dengan menambahkan fitur seperti pengelolaan banyak karakter, pencarian karakter, GUI menggunakan Java Swing, serta penerapan konsep MVC.

Pada sprint berikutnya, project dapat dikembangkan agar data karakter tidak hanya ditampilkan melalui console, tetapi juga dapat ditampilkan melalui tampilan graphical user interface (GUI).

---

## 11. Identitas Mahasiswa

**Nama:** Arini Balqis  
**NIM:** 253303621263  
**Kelas:** 3 Pagi B  
**Mata Kuliah:** Java Visual (SIH-6406)  
**Tugas:** TP3 — Character Manager Sprint #1

---

## 12. Dokumentasi Analisis Desain

Analisis mengenai ekosistem Java, JVM, JRE, JDK, bytecode, encapsulation, constructor, enum, UML class, serta refleksi pengembangan karakter terdapat pada Google Docs untuk **Bagian D**.

**Google Docs:**  
[Klik di sini untuk membuka Google Docs](MASUKKAN-LINK-GOOGLE-DOCS-DI-SINI)

Dokumen Google Docs digunakan sebagai bagian dari dokumentasi analisis desain dan menjelaskan alasan penggunaan struktur serta fitur yang diterapkan pada project Character Manager.

---

## 13. Repository

Project ini dibuat sebagai bagian dari tugas **Character Manager Sprint #1 — TP3** dan akan dikumpulkan melalui repository GitHub.

Repository:

```text
javavisual-tp03-253303621263
```

Repository berisi source code Java, README, dan dokumentasi yang diperlukan sesuai dengan ketentuan tugas.

---

## 14. Kesimpulan

TP3 ini menghasilkan fondasi awal project Character Manager menggunakan bahasa pemrograman Java. Program telah menerapkan class, object, constructor, encapsulation, enum, getter dan setter, serta beberapa method untuk mengatur perilaku karakter.

Selain fitur dasar, project juga telah dikembangkan dengan atribut `mana` dan method `isAlive()`. Dengan struktur package yang terorganisasi, project ini dapat dilanjutkan ke tahap pengembangan berikutnya tanpa harus mengubah keseluruhan struktur program.

# Character Manager — TP5 (Java Visual SIH-6406)

## Deskripsi

Project ini merupakan pengembangan **Character Manager Sprint #2** pada mata kuliah Java Visual (SIH-6406). Pada TP5, program dikembangkan dengan menambahkan class `CharacterManager` untuk mengelola data karakter menggunakan `ArrayList`, serta menerapkan konsep **encapsulation, reference, object comparison, defensive copy, dan static counter**.

Selain fitur dasar pengelolaan karakter, program juga memiliki fitur pencarian berdasarkan nama dan tipe karakter, penghapusan karakter, perhitungan jumlah karakter, rata-rata level, serta fitur analitik tambahan.

---

## Fitur TP5

Beberapa fitur yang telah diimplementasikan dalam project ini:

- Menambahkan karakter menggunakan `addCharacter()`
- Mencari karakter berdasarkan nama menggunakan `findByName()`
- Menghapus karakter menggunakan `removeCharacter()`
- Menghitung jumlah karakter menggunakan `getTotalCharacters()`
- Mengambil seluruh karakter menggunakan `getAllCharacters()`
- Menolak penambahan karakter dengan nama yang sama
- Membandingkan karakter berdasarkan nama menggunakan `equals()`
- Menghitung rata-rata level menggunakan `getAverageLevel()`
- Mencari karakter berdasarkan `CharacterType` menggunakan `findByType()`
- Menggunakan defensive copy pada `getAllCharacters()`
- Menggunakan `static totalCharacterCreated` untuk menghitung jumlah karakter yang pernah dibuat
- Menambahkan fitur analitik `findStrongest()` untuk mencari karakter dengan level tertinggi

---

## Struktur Project

```text
PROJECTJAVA/
│
├── out/
│
├── src/
│   └── com/
│       └── unpri/
│           └── charactermanager/
│               │
│               ├── Main.java
│               │
│               └── model/
│                   ├── Character.java
│                   ├── CharacterManager.java
│                   └── CharacterType.java
│
├── screenshots/
│   └── output terminal TP5.png
│
└── README.md
```

---

## CharacterManager

Class `CharacterManager` digunakan untuk mengelola kumpulan object `Character`. Data karakter disimpan menggunakan `ArrayList<Character>`.

Method utama yang tersedia:

```java
addCharacter()
findByName()
removeCharacter()
getTotalCharacters()
getAllCharacters()
getAverageLevel()
findByType()
findStrongest()
```

Program juga melakukan pengecekan nama sebelum karakter ditambahkan. Jika nama karakter sudah digunakan, karakter baru akan ditolak agar tidak terjadi data duplikat.

---

## Penolakan Nama Duplikat

Program menggunakan method `equals()` pada class `Character` untuk membandingkan nama karakter.

Contoh:

```text
=== ADD CHARACTER ===
Arthur berhasil ditambahkan.
Merlin berhasil ditambahkan.
Robin berhasil ditambahkan.

=== DUPLICATE TEST ===
Nama karakter sudah digunakan.
Hasil penambahan: false
```

Dengan demikian, dua karakter tidak dapat memiliki nama yang sama di dalam `CharacterManager`.

---

## Defensive Copy

Method `getAllCharacters()` tidak mengembalikan `ArrayList` asli. Method tersebut mengembalikan salinan dari list.

Tujuannya adalah menjaga **encapsulation** sehingga kode dari luar class tidak dapat mengubah langsung data internal `CharacterManager`.

Contoh konsep:

```java
public ArrayList<Character> getAllCharacters() {
    return new ArrayList<>(characters);
}
```

Dengan cara tersebut, perubahan terhadap list hasil pengambilan tidak akan mengubah list asli yang berada di dalam `CharacterManager`.

---

## Mini-Challenge

### 1. Average Level

Method:

```java
getAverageLevel()
```

digunakan untuk menghitung rata-rata level seluruh karakter.

Jika tidak terdapat karakter, method mengembalikan nilai:

```text
0.0
```

Hal tersebut dilakukan untuk menghindari pembagian dengan nol.

### 2. Find By Type

Method:

```java
findByType(CharacterType type)
```

digunakan untuk mencari semua karakter berdasarkan tipe tertentu seperti:

```text
WARRIOR
MAGE
ARCHER
ASSASSIN
```

Hasil pencarian dikembalikan dalam bentuk `ArrayList<Character>`.

---

## Fitur Analitik Tambahan

Fitur tambahan yang dibuat pada TP5 adalah:

```java
findStrongest()
```

Method ini digunakan untuk mencari karakter dengan **level tertinggi** di dalam `CharacterManager`.

Fitur ini membantu pengguna mengetahui karakter yang memiliki level paling tinggi tanpa harus memeriksa seluruh data secara manual.

Method ini juga menjaga encapsulation karena tidak memberikan akses langsung terhadap `ArrayList` internal.

Contoh Javadoc:

```java
/**
 * Mencari karakter dengan level tertinggi.
 *
 * @return karakter dengan level tertinggi,
 *         atau null jika tidak ada karakter.
 */
public Character findStrongest() {
    if (characters.isEmpty()) {
        return null;
    }

    Character strongest = characters.get(0);

    for (Character character : characters) {
        if (character.getLevel() > strongest.getLevel()) {
            strongest = character;
        }
    }

    return strongest;
}
```

---

## Eksperimen Reference

TP5 juga menguji konsep reference pada Java.

Contoh:

```java
Character a = new Character(
    10,
    "Arthur",
    5,
    CharacterType.WARRIOR
);

Character b = a;

b.setLevel(8);

System.out.println(a.getLevel());
System.out.println(a == b);
```

Output:

```text
8
true
```

Hal tersebut terjadi karena `a` dan `b` menunjuk ke object yang sama di memory. Ketika `b` mengubah level, perubahan tersebut juga terlihat melalui `a`.

Untuk membuat object yang benar-benar independen, diperlukan object baru menggunakan constructor atau mekanisme copy yang sesuai.

---

## Static Counter

Class `CharacterManager` memiliki:

```java
private static int totalCharacterCreated;
```

Variabel tersebut digunakan untuk menghitung jumlah karakter yang telah dibuat secara keseluruhan.

Karena bersifat `static`, variabel tersebut dimiliki bersama oleh seluruh object `CharacterManager`, bukan oleh satu object saja.

Contoh output:

```text
=== STATIC COUNTER ===
Total karakter yang pernah dibuat: 4
```

---

## Screenshot Output

Screenshot hasil program dapat dilihat pada folder:

```text
screenshots/output terminal TP5.png
```

Contoh output program mencakup:

- Data karakter
- Penambahan karakter
- Pengujian nama duplikat
- Pencarian karakter
- Penghapusan karakter
- Average level
- Find by type
- Eksperimen reference
- Fitur findStrongest()
- Static counter

![Output Terminal TP5](screenshots/output%20terminal%20TP5.png)

---

## Dokumentasi Google Docs

Analisis Bagian D mengenai **Reference & Rancangan** dibuat pada Google Docs.

**Nama:** Arini Balqis  
**NIM:** 253303621263  
**Kelas:** 3 Pagi B  
**Mata Kuliah:** Java Visual (SIH-6406)

**Link Google Docs:**  
`MASUKKAN LINK GOOGLE DOCS DI SINI`

Pastikan akses Google Docs sudah diatur menjadi:

**Anyone with the link — Viewer**

---

## Teknologi

Project ini dibuat menggunakan:

- Bahasa pemrograman: **Java**
- JDK: **JDK 17 / 21**
- IDE: **Visual Studio Code**
- Version Control: **Git**
- Repository: **GitHub**

---

## Kesimpulan TP5

TP5 mengembangkan project Character Manager dari tahap dasar menjadi program yang mampu mengelola sekumpulan object karakter. Implementasi `CharacterManager` memperkenalkan pengelolaan data menggunakan `ArrayList`, pencarian, penghapusan, validasi nama duplikat, perhitungan statistik, serta fitur analitik tambahan.

Melalui TP5, konsep Java seperti **reference, primitive value, `equals()`, `static`, encapsulation, dan defensive copy** juga diterapkan secara langsung dalam kode. Dengan demikian, project tidak hanya berfokus pada program yang dapat berjalan, tetapi juga memahami alasan desain dan perilaku object dalam Java.