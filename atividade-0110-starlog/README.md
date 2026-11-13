# Atividade 01/10 — Incidente StarLog-Zero

Reconstrução do motor de cargas da estação: `Carga` com fail-fast e `equals`/`hashCode` pelo código de rastreio, `CapacidadeExcedidaException` (checked), `ModuloCarga` com trava de capacidade e relatórios com Streams (sem `for`/`if`), e `BaseLancamento` com `HashMap`. A `MainResgate` roda os 4 ataques do Chaos Monkey.

## Como rodar

Abra o terminal na pasta do projeto (onde está este README). É preciso ter o JDK 17 ou superior.

**macOS / Linux**

```bash
javac -encoding UTF-8 -sourcepath src -d bin src/br/com/starlog/main/MainResgate.java
java -cp "bin" br.com.starlog.main.MainResgate
```

**Windows**

```bat
javac -encoding UTF-8 -sourcepath src -d bin src\br\com\starlog\main\MainResgate.java
java -cp "bin" br.com.starlog.main.MainResgate
```

## Resultado esperado

Os 4 ataques mostram `✅ SUCESSO` e o seguro total é R$ 100.0.
