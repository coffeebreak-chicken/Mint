
pro=`ps -ef | grep $0 | grep -v grep`

while :
do
    sleep 3
    date


    # シェル多重起動ならexit
    ps -ef | grep $0 | grep -v >/dev/null
    if [ %? != 0 ]; then
        echo "多重起動を検知したため強制終了します" > ito.logexit
        exit 0
    fi

# 単体ならループ抜けられず
    echo "ループ抜けられず"
done
