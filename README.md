# 📘 Debezium + Hazelcast Jet Entegrasyonu

## 🎯 Amaç
- Bu sistemin amacı, databasedeki tablolar üzerinde çalışan CDC (Change Data Capture) ve 
batch (toplu okuma) işlemleri ile verileri Hazelcast IMap’lere yazmaktır. Bu yapı sayesinde hem geçmiş veri yüklemesi (batch) 
yapılır, hem de yeni gelen değişiklikler (CDC) eş zamanlı olarak yakalanır.

## 📦 Proje Bileşenleri

- **Debezium Oracle Connector** : Oracle redo log'lardan veri değişikliklerini alır.
- **Hazelcast Jet**: Hem batch hem de stream veriyi işler.
- **Hazelcast IMap**: Değişen veriler buraya yazılır.
- **FlightSegment ve Inventory** tabloları için ayrı ayrı batch + CDC pipeline’ları.

---

## 🛠 Kurulum

### Gerekli Bağımlılıklar

- Hazelcast Enterprise Jet
- Debezium Oracle Connector
- Oracle JDBC Driver
- Log4j + SLF4J
- Java 21

## 📦 Ana Sınıf: DebeziumStarter
    - Tüm CDC ve batch job’larını başlatır.
    - Çalışan job’ları önceden durdurur.
    - Veriyi Hazelcast Jet üzerinden işler.

 ### Method Açıklamaları:
    startBatchJob(String jobName, Pipeline pipeline) 
        - Batch verisini Hazelcast IMap'e yazar. İş bitene kadar join() ile bekler.
    startCdcJob(String jobName, Pipeline pipeline)
        - CDC (Debezium) kaynaklı akışı başlatır.
    stopAllJobs()
        - CDC veya batch job varsa durdurur ve bekler.

## 🔄 Batch: *BatchSourceFactory
    -Oracle’dan JDBC ile Tabloları okur. Sonuçları Hazelcast map’e yazar.


## 🌐 CDC Kaynağı: DebeziumSourceFactory
    - Debezium OracleConnector ile bir stream kaynağı oluşturur. 
    - Parametreleri CdcConfig sınıfından alır.



