import os

# 編集対象のCSV list
target_csv = ['coffee_0501.csv', 'coffee_0502.csv', 'coffee_0503.csv', 'coffee_0504.csv']

# カレントディレクトリのパス str
current_dic = os.getcwd() 

# カレントディレクトリ内に存在するファイル一覧(全量) list
here_files = os.listdir(current_dic)
# カレントディレクトリ内に存在するファイル一覧(csv) list
here_csv_files = []


# csvのみに限定
target_extension = '.csv'
for i in here_files :
    if i.endswith(target_extension) :
        here_csv_files.append(i)

print(here_files) #全量
print(here_csv_files) #csv

# [真のときの値 if 条件式 else 偽のときの値 for 任意の変数名 in イテラブルオブジェクト]
# for i in here_csv_files :
#     for j in target_csv :
#         if j in i :
#             print('編集対象のcsvが存在します.')
#             print(j)
#         else:
#             print('csvが見つかりませんでした.')

# 編集対象があれば処理続行 def候補
for i in here_csv_files :
    for j in target_csv :
        if j in i :
            print('編集対象のcsvが存在します.')
            print(j, 'を編集します.')
        else:
            print('csvが見つかりませんでした.')
            break

# # 編集したファイル名の判定 -> 最後でいい
# for i in here_csv_files :
#     if target_csv[0] in i :
#         print('編集対象のcsvが存在します.')
#         print(i)
#     if target_csv[1] in i :
#         print('編集対象のcsvが存在します.')
#         print(i)
#     if target_csv[2] in i :
#         print('編集対象のcsvが存在します.')
#         print(i)
#     if target_csv[3] in i :
#         print('編集対象のcsvが存在します.')
#         print(i)
#     else:
#         print('見つかりませんでした.')


# csvを解析
import csv

# 1カラム目に目的の'平成21年度実績'があれば格納 list
coffee = []
year20 = {'平成20年度実績':[]}
year21 = {'平成21年度実績':[]}
year22 = {'平成22年度実績':[]}

# with open(j='csv_file') as f :
with open('coffee_0501.csv') as f :
	data = csv.reader(f) # 1行ずつリストっぽいものへ格納　_csv.reader
	for line in data:
            print('line変数', line)
            if '平成20年度実績' in line[0] :
                # year20 = {'平成20年度実績':line}
                year20['平成20年度実績'].append(line)
            elif '平成21年度実績' in line[0] :
                # year21 = {'平成21年度実績':line}
                year21['平成21年度実績'].append(line)
            elif '平成22年度実績' in line[0] :
                # year22 = {'平成22年度実績':line}
                year22['平成22年度実績'].append(line)
print(year20['平成20年度実績']) #valueに一次配列が入ってしまっている。期待は二次配列
print(year21['平成21年度実績']) #['平成21年度実績', '2009', '茶・コーヒー製造業', '8', 'ＵＣＣ上島珈琲株式会社', '売上高', '0.04771', 'kg/千円', '86.8', '']
print(year22['平成22年度実績']) #これでエラー？

# for i in range(len((year20['平成20年度実績']))) :
#     coffee.append(i)
for i in year20['平成20年度実績'] :
    coffee.append(i)
for i in year21['平成21年度実績'] :
    coffee.append(i)
for i in year22['平成22年度実績'] :
    coffee.append(i)
# 入れ直したものを確認
for i in coffee:
    print(i)


# CSVファイルへの書き込み(上書き)
with open('coffee_0501_edited2.csv', 'w') as f: 
    writer = csv.writer(f)
    # 複数行を書き込むときにはwriterowsを使用
    writer.writerows(coffee)