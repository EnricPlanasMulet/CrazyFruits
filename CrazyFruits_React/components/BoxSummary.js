import 'react-native-gesture-handler';
import { StatusBar } from 'expo-status-bar';
import * as React from 'react';
import { StyleSheet, Text, View, Image, TouchableOpacity, ScrollView } from 'react-native';
import FruitContainer from '../objects/FruitContainer';

export default function BoxSummary({ route, navigation }) {
    const { box } = route.params;
    return (
        <View style={styles.wrapper}>

<Image source={require('../assets/images/backgroundVector.png')} style={styles.backgroundForm} />

            {/*BackButton*/}
            <TouchableOpacity onPress={() => navigation.navigate('HomePage')}>
                <Image style={styles.arrow} source={require('../assets/images/backButton.png')} />
            </TouchableOpacity>

            {/*Your Box Title*/}
            <View style={styles.titleWrapper}>
                <Text style={styles.buyBoxTitle}>Your box</Text>
                <Image source={require('../assets/images/fullBox.png')} style={styles.yourBoxesImage} />
            </View>

            {/*BoxCard*/}
            <View style={styles.container}>
                <View style={styles.idAndDate}>
                    <Text style={styles.idAndDateText}>Box #{box.boxID} - </Text>
                    <Text style={styles.idAndDateText}>{box.date}</Text>
                    <View style={styles.square}>
                        <Image source={require('../assets/images/closedBox.png')} style={styles.box} />
                    </View>
                </View>
                <Text style={styles.city}>{box.city}, {box.zipCode}</Text>
                <Text style={styles.city}>{box.direction}</Text>

                <View style={styles.statusWrapper}>
                    <Text style={styles.deliveryText}>{box.status}</Text>
                    <Image source={box.image} style={styles.statusImage} />
                </View>
            </View>

            {/*Fruits of the box*/}
            <View style={styles.boxFruitsWrapper}>
                <Text style={styles.fruitsSubtitle}>The fruits of your box</Text>

                {/*List of fruits of the box*/}
                <View style={styles.fruitsListWrapper}>
                    {box.fruits.map((props, id) => (
                        <FruitContainer key={id} name={props.name}>
                        </FruitContainer>
                    ))}
                </View>
            </View>
        </View>
    )
}

const styles = StyleSheet.create({
    wrapper: {
        paddingLeft: 20,
        marginRight:-6,
        paddingTop: 35,
        marginBottom: 30
    },
    arrow: {
        width: 64,
        height: 24
    },
    backText: {
        fontFamily: "SFProTextRegular",
        fontSize: 17,
        color: '#007AFF'
    },
    container: {
        width: 375,
        marginTop: 15,
        backgroundColor: '#fff',
        borderRadius: 13,
        shadowOffset: {
            height: 4,
        },
        shadowColor: '#000',
        shadowOpacity: 0.1,
    },
    idAndDate: {
        flexDirection: "row",
        marginLeft: 67,
        marginTop: 16,
        marginBottom: 5
    },
    idAndDateText: {
        fontFamily: "SFProRoundedRegular",
        fontSize: 15,
        color: '#8A8A8E',
    },
    square: {
        marginLeft: -52,
        height: 40,
        width: 40,
        position: "absolute",
        backgroundColor: '#E8E8E9',
        borderRadius: 6,
        alignItems: "center",
    },
    box: {
        marginVertical: '20%',
        width: 25,
        height: 25
    },
    city: {
        marginRight: 50,
        marginLeft: 67,
        marginTop: 0,
        fontFamily: "SFProRoundedRegular",
        fontSize: 18,
        color: '#000',
    },
    statusWrapper: {
        flexDirection: "row",
        alignItems: "center",
    },
    deliveryText: {
        marginLeft: 67,
        marginTop: 5,
        marginBottom: 15,
        fontFamily: "SFProRoundedMedium",
        fontSize: 18,
        color: '#000',
    },
    statusImage: {
        marginRight: 50,
        marginBottom: 11,
        marginLeft: 7,
        height: 18,
        width: 18,
    },
    titleWrapper: {
        marginTop: 10,
        flexDirection: "row",
        alignItems: "center",
    },
    buyBoxTitle: {
        fontFamily: 'SFProRoundedBold',
        fontSize: 34,
    },
    yourBoxesImage: {
        marginTop: 5,
        marginLeft: 10,
        width: 25,
        height: 25
    },
    boxFruitsWrapper: {
        marginTop: 20,
        

    },
    fruitsSubtitle: {
        fontFamily: "SFProRoundedMedium",
        fontSize: 18,
    },
    fruitsListWrapper:{
 
        marginTop:10,
        flexDirection:"row",
        flexWrap:"wrap",

        
    },
    backgroundForm: {
        position: "absolute",
        marginTop: '80%',
        marginLeft: '40%',
        width: 271,
        height: 610,
    },
});