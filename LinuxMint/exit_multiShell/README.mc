バッチでのふるまいの制御
-- javaから複数shellを"直列"で実行する場合
-- forで順番に実行するが、前のshell処理が終わらない内に次のshellが起動すると障害
-- →前のshell処理が食われてしまう。
-- 通常ではエラー検知されないので、検知したい！

多重起動を検知する処理
