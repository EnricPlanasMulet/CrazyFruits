import 'react-native-gesture-handler';
import { StatusBar } from 'expo-status-bar';
import * as React from 'react';
import { StyleSheet, Text, View, Image, TouchableOpacity } from 'react-native';

import ModalDropdown from 'react-native-modal-dropdown';




export default HomePage = () => {
    return (
        <View style={styles.container}>

            {/*Background Image*/}
            <Image source={require('../assets/images/backgroundVector.png')} style={styles.backgroundForm}></Image>

            {/*Header*/}
            <View style={styles.headerWrapper}>
                <View style={styles.userWrapper}>
                    <Image source={require('../assets/images/fotoLinkedIn.jpg')} style={styles.profileImage}></Image>
                    <Text style={styles.userName}>Enric Planas Mulet</Text>
                </View>
                <TouchableOpacity style={styles.settingsButton}>
                    <Image source={require('../assets/images/settings.png')} style={styles.settingsImage}></Image>
                </TouchableOpacity>
            </View>

            {/*Buy a new box*/}
            <View style={styles.buyBoxWrapper}>
                <View style={styles.titleWrapper}>
                    <Text style={styles.buyBoxTitle}>Buy a new box</Text>
                    <Image source={require('../assets/images/emptyBox.png')} style={styles.buyBoxImage}></Image>
                </View>
                <Text style={styles.shopSelectorTitle}>Select a shop</Text>
            </View>
            <View style={styles.dropdownBackground}>
                <ModalDropdown textStyle={styles.dropdownText}
                    dropdownStyle={styles.dropdownShopStyle}
                    dropdownTextStyle={styles.dropdownOptionsTextStyle}
                    defaultValue={"Select a shop...                                                                                "}
                    saveScrollPosition={false}
                    options={shops} isFullWidth={true} />
                <Image source={require('../assets/images/chevron.forward.png')} style={styles.dropdownImage}></Image>
            </View>
            <TouchableOpacity style={styles.buyBoxButton}>
                <Image source={require('../assets/images/buyBoxButton.png')} style={styles.buyBoxButtonImage}></Image>
            </TouchableOpacity>

            {/*Your Boxes*/}
            <View style={styles.titleWrapper}>
                <Text style={styles.yourBoxesTitle}>Your Boxes</Text>
                <Image source={require('../assets/images/fullBox.png')} style={styles.yourBoxesImage}></Image>
            </View>
            <StatusBar style="auto" />

        </View>
    )
}

const shops = ['Frutas de portugal                                                                                ',
    'Frutas de ibiza                                                                                ',
    'Condis BCN                                                                                ',
    'Agricultura can Tria                                                                                '];

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#F8F8F8',
    },
    headerWrapper: {
        flexDirection: "row",
        justifyContent: "space-between",
        paddingTop: 45,
        paddingHorizontal: 20,
        alignItems: "center",
    },
    userWrapper: {
        flexDirection: "row",
        alignItems: "center",
    },
    profileImage: {
        width: 40,
        height: 40,
        borderRadius: 40
    },
    userName: {
        marginLeft: 10,
        fontFamily: "SFProRoundedRegular",
        fontSize: 17,
    },
    settingsButton: {},
    settingsImage: {
        width: 24,
        height: 21
    },
    buyBoxWrapper: {
        paddingTop: 20,
        paddingHorizontal: 20,
    },
    titleWrapper: {
        flexDirection: "row",
        alignItems: "center",
    },
    buyBoxTitle: {
        fontFamily: 'SFProRoundedBold',
        fontSize: 34,
    },
    buyBoxImage: {
        marginTop: 6,
        marginLeft: 10,
        width: 25,
        height: 25
    },
    shopSelectorTitle: {
        width: '80%',
        paddingTop: 15,
        fontFamily: "SFProRoundedRegular",
        fontSize: 20,
    },
    dropdownBackground: {
        backgroundColor: '#E8E8E9',
        width: 374,
        height: 36,
        marginTop: 10,
        marginLeft: 20,
        marginRight: 20,
        borderRadius: 10,
        flexDirection: "row",
    },
    dropdownImage: {
        position: "absolute",
        marginTop: 15,
        marginLeft: 340,
        width: 14,
        height: 8
    },
    dropdownText: {
        paddingLeft: 20,
        marginTop: 8,
        fontFamily: "SFProRoundedRegular",
        fontSize: 17,
    },
    dropdownShopStyle: {
        borderTopLeftRadius: 0,
        borderTopRightRadius: 0,
        borderRadius: 10,
        backgroundColor: '#E8E8E9',
        borderTopColor: '#E8E8E9',
        width: 374,
    },
    dropdownOptionsTextStyle: {
        fontFamily: "SFProRoundedRegular",
        fontSize: 17,
        color: '#000',
        marginLeft: 4,
        marginBottom: 4,
        marginRight: 4,
        backgroundColor: '#E8E8E9',
        borderRadius: 10,
        textAlign: 'center'
    },
    buyBoxButtonImage: {
        marginTop: 30,
        alignSelf: "center",
        width: 190,
        height: 51
    },
    yourBoxesTitle: {
        fontFamily: 'SFProRoundedBold',
        fontSize: 34,
        paddingLeft: 20,
        paddingTop: 30,
    },
    yourBoxesImage: {
        marginTop: 35,
        marginLeft: 10,
        width: 25,
        height: 25
    },
    backgroundForm: {
        position: "absolute",
        marginTop: '80%',
        marginLeft: '40%',
        width: 271,
        height: 610
    },
});